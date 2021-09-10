package com.reintegro.profuturo.app.presenter;

import com.reintegro.profuturo.app.base.PresenterBase;
import com.reintegro.profuturo.app.contract.DocumentsCaptureContract;
import com.reintegro.profuturo.app.domain.dto.ClientDto;
import com.reintegro.profuturo.app.domain.dto.DocumentDto;
import com.reintegro.profuturo.app.domain.dto.ProcedureDto;
import com.reintegro.profuturo.app.util.Constants;
import com.reintegro.profuturo.app.util.DocumentUtils;
import com.reintegro.profuturo.app.util.Utils;

import java.io.File;
import java.util.List;

public class DocumentsCapturePresenter
    extends PresenterBase<DocumentsCaptureContract.Interactor, DocumentsCaptureContract.State, DocumentsCaptureContract.View>
    implements DocumentsCaptureContract.Presenter{

    @Override
    public void resume() {
        view.showLoading();
        interactor.getClientData();
        interactor.getProcedureInfo();
    }

    @Override
    public void onGetClientDataSuccess(ClientDto clientDto) {
        view.showClientData(clientDto.getFullName() + " • " + Utils.formatClientAccountNumber(clientDto.getAccountNumber()));
        view.setClient(clientDto);
        interactor.getDocuments();
    }

    @Override
    public void onGetProcedureInfoSuccess(ProcedureDto procedureDto) {
        view.setApplicantType(procedureDto.getIdApplicantType());
    }

    @Override
    public void onGetDocumentsSuccess(List<DocumentDto> documents) {
        state.setDocuments(documents);

        for (DocumentDto document : documents){
            switch (document.getDocumentKey()){
                case Constants.DOCUMENT_KEY_REPAYMENT_SOLICITUDE:
                    DocumentUtils.setRepaymentSolicitude(document);
                    break;
                case Constants.DOCUMENT_KEY_REPAYMENT_LETTER:
                    DocumentUtils.setRepaymentLetter(document);
                    break;
                case Constants.DOCUMENT_KEY_OFFICIAL_ID_BACK:
                    DocumentUtils.setOfficialIdBack(document);
                    break;
                case Constants.DOCUMENT_KEY_OFFICIAL_ID_FRONT:
                    DocumentUtils.setOfficialIdFront(document);
                    break;
                case Constants.DOCUMENT_KEY_LEGAL_OFFICIAL_ID_BACK:
                    DocumentUtils.setLegalOfficialIdBack(document);
                    break;
                case Constants.DOCUMENT_KEY_LEGAL_OFFICIAL_ID_FRONT:
                    DocumentUtils.setLegalOfficialIdFront(document);
                    break;
                case Constants.DOCUMENT_KEY_POWER_ATTORNEY:
                    DocumentUtils.setPowerOfAttorney(document);
                    break;
                case Constants.DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_BACK:
                    DocumentUtils.setGuardianOfficialIdBack(document);
                    break;
                case Constants.DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_FRONT:
                    DocumentUtils.setGuardianOfficialIdFront(document);
                    break;
                case Constants.DOCUMENT_KEY_SENTENCE:
                    DocumentUtils.setSentence(document);
                    break;
            }
        }
        view.showDocuments(documents);
        view.dismissLoading();
    }

    @Override
    public void onGetDocumentsError() {
        view.showGetDocumentsError();
        view.dismissLoading();
    }

    @Override
    public void onClickCancel() {
        view.showCancelDialog();
    }

    @Override
    public void onClickEnterFullscreen() {
        view.showFullscreenDocument(state.getSelectedDocument());
    }

    @Override
    public void onClickExitFullscreen() {
        view.exitFullscreen();
    }

    @Override
    public void onClickSave() {
        interactor.validateRequiredDocuments(state.getDocuments());
    }

    @Override
    public void onClickPreviewDocument(int position) {
        state.setSelectedDocument(state.getDocuments().get(position));

        switch (state.getSelectedDocument().getDocumentType()) {
            case Constants.DOCUMENT_TYPE_PDF:
                view.showLoading();
                if (state.getSelectedDocument().getDocumentKey() == Constants.DOCUMENT_KEY_REPAYMENT_SOLICITUDE){
                    interactor.buildSolicitudeDocument(state.getSelectedDocument());
                }else {
                    interactor.buildLetterDocument(state.getSelectedDocument());
                }
                break;

            case Constants.DOCUMENT_TYPE_PHOTO:
                if (state.getSelectedDocument().isCaptured()) {
                    view.showDocumentPhoto(state.getSelectedDocument(), true);
                } else {
                    view.showDocumentNotCapturedError();
                    view.showEmptyDocument(state.getSelectedDocument());
                }

                break;
        }
    }

    @Override
    public void onClickTakeDocumentPhoto(int position) {
        state.setSelectedDocument(state.getDocuments().get(position));
        view.pushTakeDocumentPhoto();
    }

    @Override
    public void onClickSignDocument(int position) {
        state.resetSignatureCount();
        state.setSelectedDocument(state.getDocuments().get(position));

        if (state.getSelectedDocument().getDocumentKey() == Constants.DOCUMENT_KEY_REPAYMENT_LETTER){
            view.showLoading();
            interactor.buildLetterDocument(state.getSelectedDocument());
        }else {
            for (String name : state.getSelectedDocument().getSignatureHolders().keySet()) {
                view.pushSignDocument(name);
            }
        }
    }

    @Override
    public void onTakeDocumentPhotoReady() {
        view.takeDocumentPhoto(state.getSelectedDocument());
    }

    @Override
    public void onTakeDocumentPhotoSuccess(File file) {
        state.getSelectedDocument().setCaptured(true);
        state.getSelectedDocument().setFile(file);

        view.showDocumentPhoto(state.getSelectedDocument(), false);
    }

    @Override
    public void onUpdateDocumentSignature(String signature, String signatureHolder) {
        if (state.getSelectedDocument().getDocumentKey() == Constants.DOCUMENT_KEY_REPAYMENT_SOLICITUDE){
            state.getSelectedDocument().getSignatureHolders().put(signatureHolder, signature);
            state.incrementSignatureCount();

            if (state.getSignatureCount() == state.getSelectedDocument().getSignatureHolders().size()) {
                view.showLoading();
                interactor.buildSolicitudeDocument(state.getSelectedDocument());
            }else{
                //view.showSignatureNeededError();
            }
        }
    }

    @Override
    public void validateRequiredDocumentError() {
        view.showRequiredDocumentsError();
    }

    @Override
    public void onSaveDocumentsSuccess() {
        view.pushNextScreen();
    }

    @Override
    public void onBuildSolicitudeDocumentSuccess(DocumentDto document) {
        boolean signature = true;
        if (document.getSignatureHolders().size() != 0) {
            for (String value : document.getSignatureHolders().values()) {
                if (value.isEmpty()) {
                    signature = false;
                    break;
                }
            }
        }

        if (signature) {
            document.setCaptured(true);
        }

        view.showDocumentPdf(document);
        view.dismissLoading();
    }

    @Override
    public void onBuildSolicitudeDocumentError() {
        view.showBuildDocumentError();
        view.dismissLoading();
    }

    @Override
    public void onBuildLetterDocumentSuccess(DocumentDto document) {
        document.setCaptured(true);
        view.showDocumentPdf(document);
        view.dismissLoading();
    }

    @Override
    public void onBuildLetterDocumentError() {
        view.showBuildDocumentError();
        view.dismissLoading();
    }

    @Override
    public void onIdTypeSelected(String idType) {
        view.showLoading();

        List<DocumentDto> documents;
        documents = state.getDocuments();
        switch (idType){
            case Constants.ID_TYPE_INE:
            case Constants.ID_TYPE_MIGRATION_DOC:
                for (DocumentDto document : documents){
                    switch (document.getDocumentKey()){
                        case Constants.DOCUMENT_KEY_OFFICIAL_ID_FRONT:
                        case Constants.DOCUMENT_KEY_OFFICIAL_ID_BACK:
                        case Constants.DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_FRONT:
                        case Constants.DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_BACK:
                        case Constants.DOCUMENT_KEY_LEGAL_OFFICIAL_ID_FRONT:
                        case Constants.DOCUMENT_KEY_LEGAL_OFFICIAL_ID_BACK:
                            document.setRequiredByProfuturo(true);
                            document.setFile(null);
                            document.setCaptured(false);
                            break;
                    }
                }
                break;
            case Constants.ID_TYPE_PASSPORT:
            case Constants.ID_TYPE_MILITARY:
            case Constants.ID_TYPE_PROFESSIONAL:
                for (DocumentDto document : documents){
                    switch (document.getDocumentKey()){
                        case Constants.DOCUMENT_KEY_OFFICIAL_ID_FRONT:
                        case Constants.DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_FRONT:
                        case Constants.DOCUMENT_KEY_LEGAL_OFFICIAL_ID_FRONT:
                            document.setRequiredByProfuturo(true);
                            document.setFile(null);
                            document.setCaptured(false);
                            break;
                        case Constants.DOCUMENT_KEY_OFFICIAL_ID_BACK:
                        case Constants.DOCUMENT_KEY_GUARDIAN_OFFICIAL_ID_BACK:
                        case Constants.DOCUMENT_KEY_LEGAL_OFFICIAL_ID_BACK:
                            document.setRequiredByProfuturo(false);
                            document.setFile(null);
                            document.setCaptured(false);
                            break;
                    }
                }
                break;
            default:
        }
        state.setDocuments(documents);
        view.showUpdatedDocumentsList(documents);
        view.dismissLoading();
    }
}
