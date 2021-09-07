package com.reintegro.profuturo.app.android.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.databinding.DataBindingUtil;

import com.reintegro.profuturo.app.R;
import com.reintegro.profuturo.app.databinding.DialogModifyNotificationChannelBinding;
import com.reintegro.profuturo.app.domain.dto.NotificationChannelDto;

public class ModifyNotificationChannelDialog extends AppCompatDialogFragment {
    private DialogModifyNotificationChannelBinding viewDataBinding;
    private NotificationChannelDto notificationChannelDto;
    private OnCompleteListener onCompleteListener;

    public interface OnCompleteListener {
        void onComplete(NotificationChannelDto notificationChannelDto);
    }

    public ModifyNotificationChannelDialog(NotificationChannelDto notificationChannelDto) {
        this.notificationChannelDto = notificationChannelDto;
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    private View.OnClickListener closeOnClickListener = (view) -> dismiss();

    private View.OnClickListener positiveOnClickListener = (view) -> {
        notificationChannelDto.setCellPhone(viewDataBinding.cellPhoneEditText.getText());
        notificationChannelDto.setEmail(viewDataBinding.emailEditText.getText());

        onCompleteListener.onComplete(notificationChannelDto);
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_modify_notification_channel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.cellPhoneEditText.setText(notificationChannelDto.getCellPhone());
        viewDataBinding.emailEditText.setText(notificationChannelDto.getEmail());
        viewDataBinding.closeImageView.setOnClickListener(closeOnClickListener);
        viewDataBinding.positiveButton.setOnClickListener(positiveOnClickListener);
    }
}
