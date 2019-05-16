package services;

import Converters.FrequentlyConventer;
import Modele.Frequently;
import dao.FrequentlyDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelFX.FrequentlyFx;
import org.hibernate.Session;
import sessions.UserSession;

import java.util.ArrayList;
import java.util.List;

public class StudentFrequentlyService {
    private ObservableList<FrequentlyFx> frequentlyFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<FrequentlyFx> frequentlyFxObjectProperty = new SimpleObjectProperty<>(new FrequentlyFx());
    private List<FrequentlyFx> frequentlyFxList = new ArrayList<>();

    FrequentlyDao frequentlyDao;
    private Session currentSession;
    public void init(){
        frequentlyDao = new FrequentlyDao();
        List<Frequently> frequentlies = findAllFrequently();
        frequentlyFxList.clear();
        frequentlies.forEach(frequently -> this.frequentlyFxList.add(FrequentlyConventer.convertToFrequentlyFX(frequently)));
        this.frequentlyFxObservableList.setAll(frequentlyFxList);


    }

    public List<Frequently> findAllFrequently(){
        frequentlyDao.openCurrentSession();
        List<Frequently> frequentlies = frequentlyDao.findAllFrequentlyForStudent(UserSession.getInstance().currentUser().getStudent().getStudentId());
        frequentlyDao.closeCurrentSession();

        return frequentlies;
    }

    public String Count(){
        frequentlyDao.openCurrentSessionWithTransaction();
        Long number = frequentlyDao.countAbsence(UserSession.getInstance().currentUser().getStudent().getStudentId());
        frequentlyDao.closeCurrentSessionWithTransaction();
        String result = Long.toString(number);
        return result;


    }


    public ObservableList<FrequentlyFx> getFrequentlyFxObservableList() {
        return frequentlyFxObservableList;
    }

    public void setFrequentlyFxObservableList(ObservableList<FrequentlyFx> frequentlyFxObservableList) {
        this.frequentlyFxObservableList = frequentlyFxObservableList;
    }

    public FrequentlyFx getFrequentlyFxObjectProperty() {
        return frequentlyFxObjectProperty.get();
    }

    public ObjectProperty<FrequentlyFx> frequentlyFxObjectPropertyProperty() {
        return frequentlyFxObjectProperty;
    }

    public void setFrequentlyFxObjectProperty(FrequentlyFx frequentlyFxObjectProperty) {
        this.frequentlyFxObjectProperty.set(frequentlyFxObjectProperty);
    }

    public List<FrequentlyFx> getFrequentlyFxList() {
        return frequentlyFxList;
    }

    public void setFrequentlyFxList(List<FrequentlyFx> frequentlyFxList) {
        this.frequentlyFxList = frequentlyFxList;
    }
}
