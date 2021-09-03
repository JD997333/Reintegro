package com.reintegro.profuturo.app.android.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.android.widget.RecyclerView;
import com.reintegro.profuturo.app.databinding.ItemDocumentsCaptureBinding;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.util.Constants;

import java.util.List;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private OnItemSelectedListener photoOnItemSelectedListener;
    private OnItemSelectedListener previewOnItemSelectedListener;
    private OnItemSelectedListener signDocumentOnItemSelectedListener;
    private List<DocumentDto> documents;

    public DocumentsAdapter(LayoutInflater layoutInflater, List<DocumentDto> documents) {
        this.documents = documents;
        this.layoutInflater = layoutInflater;
    }

    public void setDocuments(List<DocumentDto> documents) {
        this.documents = documents;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_documents_capture, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DocumentDto document;
        document = documents.get(position);

        holder.viewDataBinding.photo.setOnClickListener((view) -> photoOnItemSelectedListener.onItemSelected(position));
        holder.viewDataBinding.preview.setOnClickListener((view) -> previewOnItemSelectedListener.onItemSelected(position));
        holder.viewDataBinding.sign.setOnClickListener((view) -> signDocumentOnItemSelectedListener.onItemSelected(position));

        StringBuilder documentRequired;
        documentRequired = new StringBuilder();

        if (document.isRequiredByProfuturo()) {
            documentRequired.append("* ");
        }

        documentRequired.append(document.getDocumentName());

        holder.viewDataBinding.documentName.setText(documentRequired.toString());

        switch (document.getDocumentType()) {
            case Constants.DOCUMENT_TYPE_PDF:
                holder.viewDataBinding.photo.setImageResource(R.drawable.ic_pencil);
                holder.viewDataBinding.photo.setVisibility(View.GONE);
                holder.viewDataBinding.sign.setImageResource(R.drawable.ic_pencil);
                holder.viewDataBinding.sign.setVisibility(View.VISIBLE);

                break;

            case Constants.DOCUMENT_TYPE_PHOTO:
                holder.viewDataBinding.photo.setImageResource(R.drawable.ic_camera);
                holder.viewDataBinding.photo.setVisibility(View.VISIBLE);
                holder.viewDataBinding.sign.setImageResource(R.drawable.ic_camera);
                holder.viewDataBinding.sign.setVisibility(View.GONE);

                break;
        }

        if (document.isCaptured()) {
            holder.viewDataBinding.statusImageView.setImageResource(R.drawable.ic_check);
        } else {
            holder.viewDataBinding.statusImageView.setImageResource(R.drawable.ic_close_red);
        }
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    public void setPhotoOnItemSelectedListener(OnItemSelectedListener photoOnItemSelectedListener) {
        this.photoOnItemSelectedListener = photoOnItemSelectedListener;
    }

    public void setPreviewOnItemSelectedListener(OnItemSelectedListener previewOnItemSelectedListener) {
        this.previewOnItemSelectedListener = previewOnItemSelectedListener;
    }

    public void setSignDocumentOnItemSelectedListener(OnItemSelectedListener signDocumentOnItemSelectedListener) {
        this.signDocumentOnItemSelectedListener = signDocumentOnItemSelectedListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ItemDocumentsCaptureBinding viewDataBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }
    }
}
