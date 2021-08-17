package com.project.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Crypto> arrayList;
    Adapter adapter;
    String[] cryptoName, cryptoDesc;
    int[] imgResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        arrayList = new ArrayList<Crypto>();

        adapter = new Adapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        cryptoName = new String[]{
                "Binance Coin (BNB)",
                "Axie Infinity (AXS)",
                "Filecoin (FIL)",
                "Cardano (ADA)",
                "Zilliqa (ZIL)",
                "Ripple Token (XRP)",
                "Solana (SOL)",
                "Polkadot (DOT)",
                "Litecoin (LTC)",
                "Polygon (MATIC)"
        };

        imgResId = new int[]{
                R.drawable.bnb,
                R.drawable.axs,
                R.drawable.fil,
                R.drawable.ada,
                R.drawable.zil,
                R.drawable.xrp,
                R.drawable.sol,
                R.drawable.polkadot,
                R.drawable.ltc,
                R.drawable.polygon,
        };

        cryptoDesc = new String[]{
                "Launched in July 2017, Binance is one of the biggest cryptocurrency exchanges globally. By aiming to bring cryptocurrency exchanges to the forefront of financial activity globally. The idea behind Binance’s name is to show this new paradigm in global finance — Binary Finance, or Binance.",
                "Axie Infinity is a blockchain-based trading and battling game that is partially owned and operated by its players. Each Axie is a non-fungible token (NFT) with different attributes and strengths and can be entered into 3v3 battles, with the winning team earning more experience (exp) points that are used to level up an Axie's stats or evolve their body parts. These Axies can be bred together to produce new and unique offspring, which can be used or sold on the Axie marketplace.",
                "Filecoin is a decentralized storage system that aims to “store humanity’s most important information.” The project raised $205 million in an initial coin offering (ICO) in 2017, and initially planned a launch date for mid-2019. However, the launch date for the Filecoin mainnet was pushed back until block 148,888, which is expected in mid-October 2020.",
                "Cardano is a proof-of-stake blockchain platform that says its goal is to allow “changemakers, innovators and visionaries” to bring about positive global change.",
                "Zilliqa is a public, permissionless blockchain that is designed to offer high throughput with the ability to complete thousands of transactions per second. It seeks to solve the issue of blockchain scalability and speed by employing sharding as a second-layer scaling solution. The platform is home to many decentralized applications, and as of October 2020, it also allows for staking and yield farming.",
                "To begin with, it’s important to understand the difference between XRP, Ripple and RippleNet. XRP is the currency that runs on a digital payment platform called RippleNet, which is on top of a distributed ledger database called XRP Ledger. While RippleNet is run by a company called Ripple, the XRP Ledger is open-source and is not based on blockchain, but rather the previously mentioned distributed ledger database.",
                "Solana is a highly functional open source project that banks on blockchain technology’s permissionless nature to provide decentralized finance (DeFi) solutions. While the idea and initial work on the project began in 2017, Solana was officially launched in March 2020 by the Solana Foundation with headquarters in Geneva, Switzerland.",
                "Polkadot is an open-source sharding multichain protocol that facilitates the cross-chain transfer of any data or asset types, not just tokens, thereby making a wide range of blockchains interoperable with each other.",
                "Litecoin (LTC) is a cryptocurrency that was designed to provide fast, secure and low-cost payments by leveraging the unique properties of blockchain technology.",
                "Polygon (previously Matic Network) is the first well-structured, easy-to-use platform for Ethereum scaling and infrastructure development. Its core component is Polygon SDK, a modular, flexible framework that supports building multiple types of applications."

        };

        getData();

        adapter.onRecycleViewClickListener(new Adapter.onRecycleViewClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, CryptoDetail.class);
                intent.putExtra("cryptoLogo", arrayList.get(position).cryptologo);
                intent.putExtra("cryptoName", arrayList.get(position).cryptoname);
                intent.putExtra("cryptoDesc", arrayList.get(position).cryptodesc);
                startActivity(intent);
            }
        });
    }

    private void getData() {

        for(int i = 0; i < cryptoName.length; i++){
            Crypto crypto = new Crypto(cryptoName[i], imgResId[i], cryptoDesc[i]);
            arrayList.add(crypto);
        }

        adapter.notifyDataSetChanged();
    }
}