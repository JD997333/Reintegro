package com.reintegro.profuturo.app.util;

import com.reintegro.profuturo.app.domain.dto.DocumentDto;

public class DocumentUtils {
    private static DocumentDto repaymentSolicitude;
    private static DocumentDto repaymentLetter;
    private static DocumentDto officialIdBack;
    private static DocumentDto officialIdFront;
    private static DocumentDto legalOfficialIdBack;
    private static DocumentDto legalOfficialIdFront;
    private static DocumentDto powerOfAttorney;
    private static DocumentDto guardianOfficialIdBack;
    private static DocumentDto guardianOfficialIdFront;
    private static DocumentDto sentence;

    public static boolean isRepaymentSolicitudeCaptured(){
        return repaymentSolicitude.isCaptured();
    }

    public static boolean isRepaymentLetterCaptured(){
        return repaymentLetter.isCaptured();
    }

    public static boolean isOfficialIdBackCaptured(){
        return officialIdBack.isCaptured();
    }

    public static boolean isOfficialIdFrontCaptured(){
        return officialIdFront.isCaptured();
    }

    public static boolean isLegalOfficialIdBackCaptured(){
        return legalOfficialIdBack.isCaptured();
    }

    public static boolean isLegalOfficialIdFrontCaptured(){
        return legalOfficialIdFront.isCaptured();
    }

    public static boolean isPowerOfAttorneyCaptured(){
        return powerOfAttorney.isCaptured();
    }

    public static boolean isGuardianOfficialIdBackCaptured(){
        return guardianOfficialIdBack.isCaptured();
    }

    public static boolean isGuardianOfficialIdFrontCaptured(){
        return guardianOfficialIdFront.isCaptured();
    }

    public static boolean isSentenceCaptured(){
        return sentence.isCaptured();
    }

    public static void setRepaymentSolicitude(DocumentDto _repaymentSolicitude) {
        repaymentSolicitude = _repaymentSolicitude;
    }

    public static void setRepaymentLetter(DocumentDto _repaymentLetter) {
        repaymentLetter = _repaymentLetter;
    }

    public static void setOfficialIdBack(DocumentDto _officialIdBack) {
        officialIdBack = _officialIdBack;
    }

    public static void setOfficialIdFront(DocumentDto _officialIdFront) {
        officialIdFront = _officialIdFront;
    }

    public static void setLegalOfficialIdBack(DocumentDto _legalOfficialIdBack) {
        legalOfficialIdBack = _legalOfficialIdBack;
    }

    public static void setLegalOfficialIdFront(DocumentDto _legalOfficialIdFront) {
        legalOfficialIdFront = _legalOfficialIdFront;
    }

    public static void setPowerOfAttorney(DocumentDto _powerOfAttorney) {
        powerOfAttorney = _powerOfAttorney;
    }

    public static void setGuardianOfficialIdBack(DocumentDto _guardianOfficialIdBack) {
        guardianOfficialIdBack = _guardianOfficialIdBack;
    }

    public static void setGuardianOfficialIdFront(DocumentDto _guardianOfficialIdFront) {
        guardianOfficialIdFront = _guardianOfficialIdFront;
    }

    public static void setSentence(DocumentDto _sentence) {
        sentence = _sentence;
    }
}
