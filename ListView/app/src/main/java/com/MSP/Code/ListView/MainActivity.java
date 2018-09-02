package com.MSP.Code.ListView;

import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
import com.MSP.Code.ListView.*;
import java.util.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		ArrayList<ProductsClass> list = new ArrayList<ProductsClass>();
		list.add(new ProductsClass("Iphon 4", "4500 EGP", R.drawable.iphone_4));
		list.add(new ProductsClass("Iphon 5", "5550 EGP", R.drawable.iphone_5));
		list.add(new ProductsClass("Iphon 6", "6700 EGP", R.drawable.iphone_6));
		list.add(new ProductsClass("Iphon 7", "8200 EGP", R.drawable.iphone_7));
		list.add(new ProductsClass("Iphon 8", "9850 EGP", R.drawable.iphone_8));
		list.add(new ProductsClass("Iphon x", "11500 EGP", R.drawable.iphone_x));

		myCustomAdapter customAdapter = new myCustomAdapter(list);

		ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(customAdapter);
	}

	private void Display(String text)
	{
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
	}

	public class myCustomAdapter extends BaseAdapter
	{
		public ArrayList<ProductsClass> list = new ArrayList<ProductsClass>();

		myCustomAdapter(ArrayList<ProductsClass> list){
			this.list = list;
		}

		@Override
		public int getCount()
		{
			return list.size();
		}

		@Override
		public String getItem(int p1)
		{
			return list.get(p1).Name;
		}

		@Override
		public long getItemId(int p1)
		{
			return p1;
		}

		@Override
		public View getView(int p1, View p2, ViewGroup p3)
		{
			LayoutInflater inflater = getLayoutInflater();
			View myView = inflater.inflate(R.layout.list_item, null);

			TextView txtName = (TextView) myView.findViewById(R.id.txt_name);
			TextView txtPrice = (TextView) myView.findViewById(R.id.txt_price);
			ImageView image = (ImageView) myView.findViewById(R.id.image_view);
			Button btn = (Button) myView.findViewById(R.id.btn);

			txtName.setText(list.get(p1).Name);
			txtPrice.setText(list.get(p1).Price);
			image.setBackgroundResource(list.get(p1).Image);

			final ProductsClass product = list.get(p1);

			btn.setOnClickListener(new View.OnClickListener(){

					@Override
					public void onClick(View view){
						Display(product.Name + "\n" + product.Price + "\n Added to Cart");
					}

				});

			return myView;
		}


	}

}
