package br.com.valcirjr98.makor.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import br.com.valcirjr98.makor.R;
import br.com.valcirjr98.makor.model.Produto;
import android.content.Context;

import java.util.List;


public class AdapterProdutos extends RecyclerView.Adapter<AdapterProdutos.MyViewHolder> {

    private List <Produto> produtos;
    private Context context;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome;
        TextView codigo;
        TextView preco;

        public  MyViewHolder(View itemView){
            super(itemView);

            nome = itemView.findViewById(R.id.textNomeProduto);
            codigo = itemView.findViewById(R.id.textCodigo);
            preco = itemView.findViewById(R.id.textPreco);

        }
    }

}
