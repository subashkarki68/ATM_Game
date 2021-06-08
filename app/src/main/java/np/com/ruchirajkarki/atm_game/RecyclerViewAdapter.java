package np.com.ruchirajkarki.atm_game;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import np.com.ruchirajkarki.atm_game.database.Character;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<Character> mCharacterList;
    Context context;
    ConstraintLayout constraintLayout;
    private OnCharacterListener mOnCharacterListener;

    public RecyclerViewAdapter(List<Character> characterList, Context context, OnCharacterListener onCharacterListener) {
        mCharacterList = characterList;
        this.context = context;
        this.mOnCharacterListener = onCharacterListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_holder, parent, false);
        return new MyViewHolder(view,mOnCharacterListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_holder.setText(mCharacterList.get(position).getCharName());
        Glide.with(context).load(mCharacterList.get(position).getCharImg()).into(holder.img_holder);
//        Toast.makeText(context.getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
//        constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(context, "Clicked" + String.valueOf("FIFIIFI"), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, CharacterDetail_View_Controller.class);
//                intent.putExtra("id", mCharacterList.get(position).getCharID());
//                context.startActivity(intent);
//
//            }
//        });
//        constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ////////////////////////////////////////////////////////////////////////
//                Toast.makeText(context, String.valueOf(presidentList.get(position).getId()), Toast.LENGTH_SHORT).show();
//                ////////////////////////////////////////////////////////////////////////
//                Intent intent = new Intent(context,president_adding_layout.class);
//                intent.putExtra("id",presidentList.get(position).getId());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_holder;
        TextView name_holder;
        OnCharacterListener onCharacterListener;

        public MyViewHolder(@NonNull View itemView, OnCharacterListener onCharacterListener) {
            super(itemView);
            img_holder = itemView.findViewById(R.id.iv_charImg);
            name_holder = itemView.findViewById(R.id.tv_charName);
            constraintLayout = itemView.findViewById(R.id.char_holder_constraint);
            this.onCharacterListener = onCharacterListener;
            constraintLayout.setOnClickListener(this);    //This refers to the implemented mehod on this class
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ERRORCHECK", "onClick: ");
                    Toast.makeText(context.getApplicationContext(), "clicked " + String.valueOf(itemView), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View v) {
            onCharacterListener.onCharacterClick(getAdapterPosition());
        }
    }
    public interface OnCharacterListener{
        void onCharacterClick(int position);
        }
    }