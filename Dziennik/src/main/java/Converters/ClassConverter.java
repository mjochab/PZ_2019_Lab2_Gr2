package Converters;

import Modele.Classes;
import modelFX.ClassesFx;

public class ClassConverter {
    public static ClassesFx convertToClassFx(Classes classes){
        ClassesFx classesFx = new ClassesFx();
        classesFx.setName(classes.getClassName());
        return classesFx;
    }
}
