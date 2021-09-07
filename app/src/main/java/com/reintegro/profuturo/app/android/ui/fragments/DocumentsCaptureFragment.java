package com.reintegro.profuturo.app.android.ui.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.ui.activity.SignatureActivity;
import com.reintegro.profuturo.app.android.ui.adapters.DocumentsAdapter;
import com.reintegro.profuturo.app.android.ui.dialogs.SimpleAlertDialog;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.android.widget.SnackBar;
import com.reintegro.profuturo.app.api.factory.RetrofitDataProviderFactory;
import com.reintegro.profuturo.app.contract.DocumentsCaptureContract;
import com.reintegro.profuturo.app.database.factory.RealmRepositoryFactory;
import com.reintegro.profuturo.app.databinding.FragmentDocumentsCaptureBinding;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.domain.interactor.DocumentsCaptureInteractor;
import com.reintegro.profuturo.app.domain.state.DocumentsCaptureState;
import com.reintegro.profuturo.app.presenter.DocumentsCapturePresenter;
import com.reintegro.profuturo.app.ui.main.NavigationAdapter;
import com.reintegro.profuturo.app.util.BitmapUtils;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.Utils;

import java.io.File;
import java.util.List;

public class DocumentsCaptureFragment extends NavigationAdapter.Fragment implements DocumentsCaptureContract.View {
    private FragmentDocumentsCaptureBinding viewDataBinding;
    private DocumentsCaptureContract.Presenter presenter;
    private DocumentsAdapter documentsAdapter;
    private ArrayAdapter<String> idTypesAdapter;
    private int selectedDocumentPosition;
    private String clientData;
    private Bitmap document;
    private Handler handler = new Handler(Looper.getMainLooper());
    private List<String> idTypes;
    private int idTypePosition;

    private static final int REQUEST_CODE_PERMISSIONS = 0;
    private static final int REQUEST_CODE_SIGN_DOCUMENT = 1;
    private static final int REQUEST_CODE_TAKE_DOCUMENT_PHOTO = 2;

    private final RecyclerView.Adapter.OnItemSelectedListener previewOnItemSelectedListener = (position) -> {
        presenter.onClickPreviewDocument(position);
    };

    private final RecyclerView.Adapter.OnItemSelectedListener takeDocumentPhotoOnItemSelectedListener = (position) -> {
        selectedDocumentPosition = position;

        presenter.onClickTakeDocumentPhoto(position);
    };

    private final RecyclerView.Adapter.OnItemSelectedListener signDocumentOnItemSelectedListener = (position) -> {
        selectedDocumentPosition = position;

        presenter.onClickSignDocument(position);
    };

    private final View.OnClickListener cancelOnClickListener = (view) -> presenter.onClickCancel();

    private final View.OnClickListener exitFullscreenOnClickListener = (view) -> presenter.onClickExitFullscreen();

    private final View.OnClickListener enterFullScreenOnClickListener = (view) -> presenter.onClickEnterFullscreen();

    private final View.OnClickListener saveOnClickListener = (view) -> presenter.onClickSave();

    private final AdapterView.OnItemSelectedListener idTypeSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            idTypePosition = position;
            presenter.onIdTypeSelected(idTypes.get(position));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DocumentsCaptureContract.Interactor interactor;
        interactor = new DocumentsCaptureInteractor(new RealmRepositoryFactory(), new RetrofitDataProviderFactory(getContext()));
        presenter = new DocumentsCapturePresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        presenter.setState(new DocumentsCaptureState());
        interactor.setPresenter(presenter);

        presenter.resume();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_documents_capture, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        viewDataBinding.cancelButton.setOnClickListener(cancelOnClickListener);
        viewDataBinding.clientDataTextView.setText(clientData);
        viewDataBinding.content.setVisibility(View.VISIBLE);
        viewDataBinding.contentDocumentImageView.setImageBitmap(document);
        viewDataBinding.documentsRecyclerView.setAdapter(documentsAdapter);
        viewDataBinding.documentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), androidx.recyclerview.widget.RecyclerView.VERTICAL, false));
        viewDataBinding.enterFullscreenImageView.setOnClickListener(enterFullScreenOnClickListener);
        viewDataBinding.enterFullscreenImageView.setVisibility(View.GONE);
        viewDataBinding.exitFullscreenImageView.setOnClickListener(exitFullscreenOnClickListener);
        viewDataBinding.fullscreen.setVisibility(View.GONE);
        viewDataBinding.fullscreenDocumentImageView.setImageBitmap(document);
        viewDataBinding.saveButton.setOnClickListener(saveOnClickListener);
        viewDataBinding.oficialIdSpinner.setOnItemSelectedListener(idTypeSelectedListener);
        viewDataBinding.oficialIdSpinner.setSelection(idTypePosition);
    }

    @Override
    public void resumeFragment() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_SIGN_DOCUMENT:
                    String key;
                    key = data.getStringExtra(SignatureActivity.EXTRA_NAME);

                    String signature;
                    signature = data.getStringExtra(SignatureActivity.EXTRA_SIGNATURE);

                    presenter.onUpdateDocumentSignature(signature, key);

                    break;

                case REQUEST_CODE_TAKE_DOCUMENT_PHOTO:
                    String path;
                    path = data.getStringExtra(Constants.EXTRA_IMAGE_ENGINE_RESULT);

                    File file;
                    file = new File(path);

                    presenter.onTakeDocumentPhotoSuccess(file);

                    break;
            }
        }
    }


    @Override
    public void showClientData(String clientData) {
        this.clientData = clientData;
        viewDataBinding.clientDataTextView.setText(clientData);
    }

    @Override
    public void showDocuments(List<DocumentDto> documents) {
        idTypes = Utils.getIdentificationTypes();
        idTypesAdapter = new ArrayAdapter<>(getContext(), R.layout.item_simple_spinner, idTypes);
        viewDataBinding.oficialIdSpinner.setAdapter(idTypesAdapter);

        documentsAdapter = new DocumentsAdapter(getLayoutInflater(), documents);
        documentsAdapter.setPreviewOnItemSelectedListener(previewOnItemSelectedListener);
        documentsAdapter.setPhotoOnItemSelectedListener(takeDocumentPhotoOnItemSelectedListener);
        documentsAdapter.setSignDocumentOnItemSelectedListener(signDocumentOnItemSelectedListener);

        viewDataBinding.documentsRecyclerView.setAdapter(documentsAdapter);
    }

    @Override
    public void showUpdatedDocumentsList(List<DocumentDto> documents) {
        documentsAdapter.setDocuments(documents);

        viewDataBinding.contentDocumentImageView.setImageBitmap(null);
        viewDataBinding.enterFullscreenImageView.setVisibility(View.GONE);
        viewDataBinding.fullscreenDocumentImageView.setImageBitmap(null);
    }

    @Override
    public void pushTakeDocumentPhoto() {
        String[] permissions;
        permissions = new String[] {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        boolean hasPermissions = true;

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(getContext(), permission) == PackageManager.PERMISSION_DENIED) {
                hasPermissions = false;
                break;
            }
        }

        if (hasPermissions) {
            presenter.onTakeDocumentPhotoReady();
        } else {
            requestPermissions(
                permissions,
                REQUEST_CODE_PERMISSIONS
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSIONS:
                boolean permissionsGranted = true;

                for (int grantResult : grantResults) {
                    if (grantResult == PackageManager.PERMISSION_DENIED) {
                        permissionsGranted = false;
                        break;
                    }
                }

                if (permissionsGranted) {
                    presenter.onTakeDocumentPhotoReady();
                } else {
                    getActivity().finish();
                }

                break;
        }
    }

    @Override
    public void takeDocumentPhoto(DocumentDto document) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBoolean(Constants.EXTRA_IMAGE_ENGINE_IS_CAMERA, true);
        bundle.putString(Constants.EXTRA_IMAGE_ENGINE_NAME, document.getDocumentName());
        bundle.putString(Constants.EXTRA_IMAGE_ENGINE_PATH, String.valueOf(document.getDocumentKey()));

        Intent intent;
        intent = new Intent();
        intent.setComponent(new ComponentName(Constants.EXTRA_IMAGE_ENGINE_PACKAGE_NAME, Constants.EXTRA_IMAGE_ENGINE_CLASS_NAME));
        intent.putExtras(bundle);

        startActivityForResult(intent, REQUEST_CODE_TAKE_DOCUMENT_PHOTO);
    }

    @Override
    public void showDocumentPhoto(DocumentDto documentDto, boolean isPreview) {
        document = BitmapFactory.decodeFile(documentDto.getFile().getAbsolutePath(), null);

        if (!isPreview) {
            documentsAdapter.notifyItemChanged(selectedDocumentPosition);
        }

        viewDataBinding.contentDocumentImageView.setImageBitmap(document);
        viewDataBinding.enterFullscreenImageView.setVisibility(View.VISIBLE);
        viewDataBinding.fullscreenDocumentImageView.setImageBitmap(document);
    }

    @Override
    public void showDocumentNotCapturedError() {
        SimpleAlertDialog simpleAlertDialog;
        simpleAlertDialog = new SimpleAlertDialog();
        simpleAlertDialog.setCancelable(false);
        simpleAlertDialog.setMessage(getString(R.string.document_not_captured_error_1));
        simpleAlertDialog.setPositiveButton(getString(R.string.accept_1), view -> simpleAlertDialog.dismiss());
        simpleAlertDialog.setTitle(getString(R.string.notice_1));
        simpleAlertDialog.show(getFragmentManager(), null);
    }

    @Override
    public void showEmptyDocument(DocumentDto documentDto) {
        document = null;

        viewDataBinding.contentDocumentImageView.setImageBitmap(document);
        viewDataBinding.enterFullscreenImageView.setVisibility(View.GONE);
        viewDataBinding.fullscreenDocumentImageView.setImageBitmap(document);
    }

    @Override
    public void showFullscreenDocument(DocumentDto documentDto) {
        viewDataBinding.content.setVisibility(View.GONE);
        viewDataBinding.fullscreen.setVisibility(View.VISIBLE);
    }

    @Override
    public void exitFullscreen() {
        viewDataBinding.content.setVisibility(View.VISIBLE);
        viewDataBinding.fullscreen.setVisibility(View.GONE);
    }

    @Override
    public void popToGreeting() {
        navigationDelegate.popToGreeting();
    }

    @Override
    public void pushSignDocument(String name) {
        Bundle extras;
        extras = new Bundle();
        extras.putString(SignatureActivity.EXTRA_NAME, name);

        Intent intent;
        intent = new Intent(getContext(), SignatureActivity.class);
        intent.putExtras(extras);

        startActivityForResult(intent, REQUEST_CODE_SIGN_DOCUMENT);
    }

    @Override
    public void showDocumentPdf(DocumentDto documentDto) {
        BitmapUtils.decodeFile(getContext(), documentDto.getFile(), bitmap -> {
            document = bitmap;

            handler.post(() -> {
                documentsAdapter.notifyItemChanged(selectedDocumentPosition);

                viewDataBinding.contentDocumentImageView.setImageBitmap(bitmap);
                viewDataBinding.enterFullscreenImageView.setVisibility(View.VISIBLE);
                viewDataBinding.fullscreenDocumentImageView.setImageBitmap(bitmap);
            });
        });
    }

    @Override
    public void showBuildDocumentError() {
        SnackBar.show(getView(), getString(R.string.build_document_error_1));
    }

    @Override
    public void showRequiredDocumentsError() {
        SnackBar.show(getView(), getString(R.string.validate_required_documents_error_1));
    }

    @Override
    public void showSignatureNeededError() {
        SnackBar.show(getView(), getString(R.string.signature_needed));
    }

    @Override
    public void pushBiometricCapture() {
        setBackEnabled(false);
        navigationDelegate.pushBiometricCapture();
    }
}
