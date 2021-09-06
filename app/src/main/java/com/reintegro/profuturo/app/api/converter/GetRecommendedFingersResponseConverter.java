package com.reintegro.profuturo.app.api.converter;

import com.google.gson.Gson;
import com.reintegro.profuturo.app.api.vo.GetRecommendedFingersResponse;
import com.reintegro.profuturo.app.vo.BiometricEngineStartRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetRecommendedFingersResponseConverter extends ResponseConverter<GetRecommendedFingersResponse, String>{
    @Override
    public String convert(GetRecommendedFingersResponse response) {
        List<GetRecommendedFingersResponse.Finger> fingerList = response.getFingers();
        BiometricEngineStartRequest request = new BiometricEngineStartRequest();
        List<BiometricEngineStartRequest.FingerEngine> fingerEngineList = new ArrayList<>();
        BiometricEngineStartRequest.FingerEngine fingerEngine;

        fingerList = getSortedArray(fingerList);

        for (GetRecommendedFingersResponse.Finger fingerResp : fingerList){
            fingerEngine = new BiometricEngineStartRequest.FingerEngine();

            switch (fingerResp.getId()){
                case 10:
                    fingerEngine.setCode(5);
                    fingerEngine.setId(1);
                    break;
                case 9:
                    fingerEngine.setCode(4);
                    fingerEngine.setId(2);
                    break;
                case 8:
                    fingerEngine.setCode(3);
                    fingerEngine.setId(3);
                    break;
                case 7:
                    fingerEngine.setCode(2);
                    fingerEngine.setId(4);
                    break;
                case 6:
                    fingerEngine.setCode(1);
                    fingerEngine.setId(5);
                    break;
                case 5:
                    fingerEngine.setCode(6);
                    fingerEngine.setId(10);
                    break;
                case 4:
                    fingerEngine.setCode(7);
                    fingerEngine.setId(9);
                    break;
                case 3:
                    fingerEngine.setCode(8);
                    fingerEngine.setId(8);
                    break;
                case 2:
                    fingerEngine.setCode(9);
                    fingerEngine.setId(7);
                    break;
                case 1:
                    fingerEngine.setCode(10);
                    fingerEngine.setId(6);
                    break;
            }

            if (fingerResp.getException() == null){
                fingerEngine.setException("");
            }else {
                if (fingerResp.getException().length() == 1){
                    fingerEngine.setException("00" + fingerResp.getException());
                }else if (fingerResp.getException().length() == 2){
                    fingerEngine.setException("0" + fingerResp.getException());
                }
            }

            fingerEngine.setQuality(0);
            fingerEngine.setSuggested(fingerResp.isSuggested());

            fingerEngineList.add(fingerEngine);
        }

        request.setEnroledProfuturo(response.isEnroladoProfuturo());
        request.setEnroledProfuturo(false);//TODO delete this line, just for TEST
        request.setFingerEngines(fingerEngineList);
        request.setForcedCapture(false);
        request.setManoDerecha(response.isRightHand());
        request.setManoIzquierda(response.isLeftHand());

        Gson gson = new Gson();

        return gson.toJson(request);
    }

    private static List<GetRecommendedFingersResponse.Finger> getSortedArray(List<GetRecommendedFingersResponse.Finger> list) {
        List<GetRecommendedFingersResponse.Finger> fingersSorted;
        fingersSorted = list;
        Collections.sort(fingersSorted, new SortById());
        return fingersSorted;
    }

    public static class SortById implements Comparator<GetRecommendedFingersResponse.Finger> {
        @Override
        public int compare(GetRecommendedFingersResponse.Finger x, GetRecommendedFingersResponse.Finger y) {
            return Integer.compare(x.getId(), y.getId());
        }
    }
}
