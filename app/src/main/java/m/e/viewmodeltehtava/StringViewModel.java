package m.e.viewmodeltehtava;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class StringViewModel extends AndroidViewModel {

    private StringListaRepository stringListaRepository;

    LiveData<List<StringEntity>> listLiveData;

    public StringViewModel(@NonNull Application application){
        super(application);
        this.stringListaRepository = new StringListaRepository(application);
        this.listLiveData = stringListaRepository.haeLista();
    }

    public void insert(String teksti) {stringListaRepository.insert(teksti);}

    public LiveData<List<StringEntity>> getAllStringEntities(){
        listLiveData = stringListaRepository.haeLista();
        return listLiveData;
    }

}
