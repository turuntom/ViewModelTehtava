package m.e.viewmodeltehtava;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StringListaRepository {

    private StringEntityDAO stringDAO;
    private LiveData<List<StringEntity>> stringEntityLiveData;

    StringListaRepository(Application application) {
        DB t = DB.getInstance(application.getApplicationContext());
        this.stringDAO = t.getStringEntityDAO();
        this.stringEntityLiveData = stringDAO.haeLiveDatalista();
    }

    public LiveData<List<StringEntity>> haeLista() {
        return stringEntityLiveData;
    }

    public void insert(String stringEntity){
        stringDAO.InsertStringEntity(new StringEntity(stringEntity));
    }

}
