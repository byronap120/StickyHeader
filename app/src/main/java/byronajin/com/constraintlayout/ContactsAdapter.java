package byronajin.com.constraintlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Byron on 1/28/2018.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> contacts;
    private Context context;


    public ContactsAdapter(Context context, List<Contact> contacts) {
        this.contacts = contacts;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.contact_row, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Contact contact = contacts.get(position);

        String indexValue = contact.getName().substring(0,1).toUpperCase();
        viewHolder.contactIndex.setText(indexValue);
        viewHolder.contactName.setText(contact.getName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contactName;
        private TextView contactIndex;

        public ViewHolder(View itemView) {
            super(itemView);
            contactIndex = itemView.findViewById(R.id.contact_index);
            contactName = itemView.findViewById(R.id.contact_name);
        }
    }
}
