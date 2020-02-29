package m.e.viewmodeltehtava;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListaFragment extends Fragment {


    //tää on interface
    private IListaFragment mCallBack;

    private ListView lv;
    private ListaAdapteri listaAdapteri;

    private Context mContext;
    private List<StringEntity> normiLista;

    private StringViewModel stringViewModelInstance;

    public interface IListaFragment {
        // TODO: Update argument type and name
    }


    public ListaFragment() {
        //tän pitää olla tyhjä muuten ei toimi
    }

    //otetaan siksi newInstance, että jos useampi UI komponentti käytössä
    public static ListaFragment newInstance() {
        ListaFragment fragment = new ListaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.lista_fragment, container, false);

        this.stringViewModelInstance = ViewModelProviders.of(this).get(StringViewModel.class);

        LiveData<List<StringEntity>> lista =  stringViewModelInstance.listLiveData;

        stringViewModelInstance.getAllStringEntities().observe(this, new Observer<List<StringEntity>>(){
            @Override
            public void onChanged(@Nullable List<StringEntity> lista){
                Log.d("Muuttunut","Merkkkijono olento: "+lista.toString());

                String[] tekstiArray = new String[lista.size()];
                for (int i = 0; i < lista.size(); i++) {
                    tekstiArray[i] = lista.get(i).stringEntity;
                }


                ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        tekstiArray
                );

                lv.setAdapter(listViewAdapter);


            }
        });


        Log.d("listafragu",lista.toString());

        normiLista = lista.getValue();




        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.lv = (ListView) view.findViewById(R.id.listaPalikka);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof IListaFragment) {
            mCallBack = (IListaFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ILISTAFragment");
        }
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }



}
