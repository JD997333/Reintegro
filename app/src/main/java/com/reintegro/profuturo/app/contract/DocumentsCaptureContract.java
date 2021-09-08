package com.reintegro.profuturo.app.contract;

import com.reintegro.profuturo.app.base.ContractBase;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;

import java.io.File;
import java.util.List;

public interface DocumentsCaptureContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void getClientData();
        void getDocuments();
        void buildLetterDocument(DocumentDto documentDto);
        void buildSolicitudeDocument(DocumentDto documentDto);
        void validateRequiredDocuments(List<DocumentDto> documentDtos);
        void saveDocuments(List<DocumentDto> documentDtos);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onClickCancel();
        void onClickEnterFullscreen();
        void onClickExitFullscreen();
        void onClickSave();
        void onClickPreviewDocument(int position);
        void onClickTakeDocumentPhoto(int position);
        void onClickSignDocument(int position);
        void onGetClientDataSuccess(ClientDto clientDto);
        void onGetDocumentsSuccess(List<DocumentDto> documents);
        void onGetDocumentsError();
        void onTakeDocumentPhotoReady();
        void onTakeDocumentPhotoSuccess(File file);
        void onUpdateDocumentSignature(String signature, String signatureHolder);
        void validateRequiredDocumentError();
        void onSaveDocumentsSuccess();
        void onBuildSolicitudeDocumentSuccess(DocumentDto documentDto);
        void onBuildSolicitudeDocumentError();
        void onBuildLetterDocumentSuccess(DocumentDto documentDto);
        void onBuildLetterDocumentError();
        void onIdTypeSelected(String idType);
    }

    interface State extends ContractBase.State{
        List<DocumentDto> getDocuments();
        DocumentDto getSelectedDocument();
        void setDocuments(List<DocumentDto> documents);
        void setSelectedDocument(DocumentDto document);
        int getSignatureCount();
        void incrementSignatureCount();
        void resetSignatureCount();
    }

    interface View extends ContractBase.View{
        void showClientData(String client);
        void showDocuments(List<DocumentDto> documents);
        void pushTakeDocumentPhoto();
        void takeDocumentPhoto(DocumentDto documentDto);
        void showDocumentPhoto(DocumentDto documentDto, boolean isPreview);
        void showDocumentNotCapturedError();
        void showEmptyDocument(DocumentDto documentDto);
        void showFullscreenDocument(DocumentDto documentDto);
        void exitFullscreen();
        void popToGreeting();
        void pushSignDocument(String name);
        void showDocumentPdf(DocumentDto document);
        void showBuildDocumentError();
        void showRequiredDocumentsError();
        void pushBiometricCapture();
        void showUpdatedDocumentsList(List<DocumentDto> documents);
        void showSignatureNeededError();
        void showCancelDialog();
        void showGetDocumentsError();
    }
}
