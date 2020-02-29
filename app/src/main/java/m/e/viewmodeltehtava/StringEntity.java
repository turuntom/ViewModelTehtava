package m.e.viewmodeltehtava;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StringEntity {

    @PrimaryKey(autoGenerate = true)
    public int Id;

    public String stringEntity;

    public StringEntity(String stringEntity){
        this.stringEntity = stringEntity;
    }


}
