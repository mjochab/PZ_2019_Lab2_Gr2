package Converters;

import Modele.Warns;
import modelFX.WarnsFx;

public class WarnsConverter {
    public static WarnsFx convertToWarnsFx(Warns warns){
        WarnsFx warnsFx = new WarnsFx();
        warnsFx.setWarns_id(warns.getWarnId());
        warnsFx.setContent(warns.getContent());
        warnsFx.setDate_created(warns.getDateCreated());
        warnsFx.setStudentFxObjectProperty(StudentConverter.convertToStudentFx(warns.getStudent()));
        warnsFx.setTeacherFxObjectProperty(TeacherConverter.convertToTeacherFx(warns.getTeacher()));
        return warnsFx;
    }

    public static Warns convertToWarns(WarnsFx warnsFx){
        Warns warns = new Warns();
        warns.setWarnId(warnsFx.getWarns_id());
        warns.setContent(warnsFx.getContent());
        warns.setDateCreated(warnsFx.getDate_created());

        return warns;
    }
}
