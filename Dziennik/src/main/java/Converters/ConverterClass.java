package Converters;

import Modele.Classes;
import modelFX.ClasFx;

public class ConverterClass {
    public static ClasFx convertToClassFX(Classes classes){
        ClasFx clasFx = new ClasFx();
        clasFx.setClassId(classes.getClassId());
        clasFx.setName(classes.getClassName());
        return clasFx;
    }
}
