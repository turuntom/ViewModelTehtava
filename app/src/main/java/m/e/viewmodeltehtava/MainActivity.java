package m.e.viewmodeltehtava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Choreographer;

import java.lang.ref.WeakReference;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.NotYetConnectedException;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements TextFragment.ITextFragment, ListaFragment.IListaFragment{

    ListaFragment listaFragment;
    TextFragment textFragment;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        Log.d("siellä","Paska pyärimään, context = "+context.toString());
        listaFragment = new ListaFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.listaFrame, listaFragment,listaFragment.getTag())
                .commit();

        textFragment = new TextFragment();
        manager.beginTransaction()
                .replace(R.id.textFrame, textFragment,textFragment.getTag())
                .commit();
    }


}
