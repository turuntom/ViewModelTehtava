package m.e.viewmodeltehtava;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StringEntityDAO {

    @Query("Select * from StringEntity")List<StringEntity> stringEntityLista();

    @Query("Select * from StringEntity")
    LiveData<List<StringEntity>> haeLiveDatalista();

    @Insert
    void InsertStringEntity(StringEntity teksti);

}
