package Converters;

import Modele.Frequently;
import modelFX.FrequentlyFX;

public class FrequentlyConventer {

        public static FrequentlyFX convertToFrequentlyFX(Frequently frequently){
            FrequentlyFX frequentlyFx = new FrequentlyFX();
            frequentlyFx.setFrequentlyID(frequently.getFrequentlyId());
            frequentlyFx.setAbsense(frequently.getAbsence());
            frequentlyFx.setAbsenceDate(frequently.getAbsenceDate());
            frequentlyFx.setStudentFxObjectProperty(StudentConverter.convertToStudentFx(frequently.getStudent()));
            return frequentlyFx;
        }

        public static Frequently convertToFrequently(FrequentlyFX frequentlyFx){
            Frequently frequently = new Frequently();
            frequently.setFrequentlyId(frequentlyFx.getFrequentlyId());
            frequently.setAbsence(frequentlyFx.getAbsense());
            frequently.setAbsenceDate(frequentlyFx.getAbsenceDate());

            return frequently;

        }
    }


