package m.e.viewmodeltehtava;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ListaAdapteri extends ArrayAdapter<String> {

    private Context context;
    private LayoutInflater layoutInflater;

    private TextView textView;
    private ArrayList<String> rivit;

    public ListaAdapteri(@NonNull Context context, int resource, @Nullable ArrayList<String> lista) {
        super(context, resource);
        this.layoutInflater = LayoutInflater.from(context);
        this.rivit = lista;
        this.context = context;

    }



    @Override
    public void add(@Nullable String object) {
        super.add(object);
        rivit.add(object);
        notifyDataSetChanged();
    }

    @Override
    public void remove(@Nullable String object) {
        super.remove(object);
        rivit.remove(object);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Log.d("täällä","Käytiin adapterissa");
        View view = layoutInflater.inflate(R.layout.lista_adapteri, parent, false);
        textView = (TextView) view.findViewById(R.id.textView);

        String currentLine = rivit.get(position);

        textView.setText(currentLine);



        return view;

    }

}
