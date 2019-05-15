package Converters;

import Modele.Frequently;
import modelFX.FrequentlyFx;

public class FrequentlyConventer {

        public static FrequentlyFx convertToFrequentlyFX(Frequently frequently){
            FrequentlyFx frequentlyFx = new FrequentlyFx();
            frequentlyFx.setFrequentlyId(frequently.getFrequentlyId());
            frequentlyFx.setAbsense(frequently.getAbsence());
            frequentlyFx.setDate(frequently.getAbsenceDate());
            frequentlyFx.setStudentFxObjectProperty(StudentConverter.convertToStudentFx(frequently.getStudent()));
            return frequentlyFx;
        }

        public static Frequently convertToFrequently(FrequentlyFx frequentlyFx){
            Frequently frequently = new Frequently();
            frequently.setFrequentlyId(frequentlyFx.getFrequentlyId());
            frequently.setAbsence(frequentlyFx.getAbsense());
            frequently.setAbsenceDate(frequentlyFx.getDate());

            return frequently;

        }
    }


