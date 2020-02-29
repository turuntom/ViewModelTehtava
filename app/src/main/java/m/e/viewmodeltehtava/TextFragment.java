package m.e.viewmodeltehtava;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class TextFragment extends Fragment {




    //tää on interface
    private ITextFragment mCallBack;
    private StringViewModel stringViewModelInstance;
    Button b;
    EditText editText;

    public interface ITextFragment {
        // TODO: Update argument type and name
    }


    public TextFragment() {
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

        View v = inflater.inflate(R.layout.text_fragment, container, false);

        editText = (EditText)v.findViewById(R.id.editText);
        b = (Button) v.findViewById(R.id.button);

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b = (Button)getView().findViewById(R.id.button);

        this.stringViewModelInstance = ViewModelProviders.of(this).get(StringViewModel.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tänne tulee kai se insertti
                String s = editText.getText().toString();
                //stringViewModelInstance.insert(s);
                stringViewModelInstance.insert(s);
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ITextFragment) {
            mCallBack = (ITextFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ITEXTFRAGMENT");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }



}
