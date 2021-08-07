package com.sunil.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ScamTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String insertquery1 = "insert into scam values(1,'CommonWealth Games Scam','Games','Suresh Kalmadi',2010,35000,'Delhi','The 2010 New Delhi Commonwealth Games have been marred by corruption and mismanagement, which have skewed India’s reputation as a nation ravaged by high levels of fraud and misuse. Commonwealth Games was founded in 1930 and is an internationally successful multi-sport event involving athletes from the Commonwealth Nations Games. The event is organized every four years by the Traditional Wealth Games Federations.')";
			String insertquery2 = "insert into scam values(2,'Telgi Scam','Stamp Papers','Abdul Karim Telgi',2003,20000,'Ajmer','Telgi was taken into police custody in November 2001 in Ajmer. His arrest came after two men peddling fake stamp papers were caught in Bengaluru in 2000. Their arrest had led to the scam being uncovered. The case was taken over by the CBI eventually.')";
			String insertquery3 = "insert into scam values(3,'Sathyam Scam','IT Company','Ramalinga Raju',2009,10000,'Hyderabad','The great stock market scandal which is known as the Indian version of Enron shook the entire country in 2009. The then founders of Satyam were found guilty of committing fraud worth 7000 crores. They fooled the government, markets and customer.')";
			String insertquery4 = "insert into scam values(4,'IPL Scam','Cricket','Lalit Modi',2010,15000,'Mumbai','IPL was launched in 2008, and since then, it is taken over the country like wildfire. A novel concept which was introduced in India for the first time, the IPL became hugely popular all over the country. As it is with most events associated with copious amounts of fame and popularity, the IPL too has generated its share of controversy and scandal. A lot of that is entwined around the person that introduced the IPL in India, Lalit Modi.')";
			String insertquery5 = "insert into scam values(5,'Harshad Mehtha','Stock Exchange','Harshad Mehta',1992,8000,'Mumbai','The scam was the biggest money market scam ever committed in India, amounting to approximately Rs. 5000 crore. The main perpetrator of the scam was stock and money market broker Harshad Mehta.He committed a fraud of over 1 billion from the banking system to buy stocks on the Bombay Stock Exchange')";
			String insertquery6 = "insert into scam values(6,'Cobbler Scam','Co-operative and society','Sohin Daya',1998,5000,'Ranchi','The Cobbler Scam is one of the biggest multi million dollars scam in Indian History, is nicknamed The Great Cobbler Scam. The main heads Daya of Dawood Shoes, Rafique Tejani of Metro Shoes and Kishore Signapurkar of Milano Shoes created fictitious cooperative societies for cobblers')";
			String insertquery7 = "insert into scam values(7,'Fodder Scam','Fabrication','Lalu Prasad Yadav',2006,7000,'Kolkata','Two decades have passed since the multi-crore fodder scam was unearthed. It involved politicians and bureaucrats belonging to successive administrations siphoning off several crores of rupees, on the pretext of purchasing livestock feed, over a period of 20 years.')";
			String insertquery8 = "insert into scam values(8,'Hawala Scam','Bribery','Anas Ahmed',1996,28000,'Kashmir','The Hawala scandal, also called the Jain Diaries case or the hawala scam was an Indian political and financial scandal involving payments allegedly sent by politicians (black money) through four hawala brokers, namely the Jain brothers.')";
			String insertquery9 = "insert into scam values(9,'IMA Scam','Finanace','Mansoor Khan',2018,6000,'Bengaluru','The multi-crore Ponzi scheme, run by Karnataka-based IMA and its group entities, allegedly duped lakhs of people promising higher returns. The scam came to light in June last year when IMA operator Mohammed Mansoor Khan fled the country, accusing Roshan Baig and some government officers of cheating him')";
			String insertquery10 = "insert into scam values(10,'Punjab National Bank Scam','Banking','Nirav Modi',2017,11500,'Mumbai','The scam stunned the financial sector of the country after a fraud worth Rs 11,400 crore was unearthed at a single branch in Mumbai.The fraud was unravelled when the officials from three diamond firms approached the PNB officials for a bank credit to import rough stones from overseas')";
			String insertquery11 = "insert into scam values(11,'Augusta WestLand Chopper Scam','Defence','SP Tyagi',2010,6500,'Delhi','The AgustaWestland VVIP chopper scam is a corruption case where it has been alleged that bribes were paid to “middlemen”, perhaps even politicians, when India agreed to buy 12 AgustaWestland helicopters built by Italian defence manufacturing giant Finmeccanica at an estimated cost of Rs 3,600 crore.')";
			String insertquery12 = "insert into scam values(12,'Airlines Scam','Kingfisher Airlines','Vijay Mallya',2018,9480,'Delhi','Mallya is accused of fraud and money laundering allegedly amounting to around 9,000 crore. He had left the country on 2 March 2016 and was declared an economic offender under the Fugitive Economic Offenders Act in January 2019.Choksi and Modi are wanted in India for 13,500 crore bank fraud in Punjab National Bank.')";
			String insertquery13 = "insert into scam values(13,'Rotomac Pen Scam','Accessories','Vikram Kothari',2014,2000,'Kolkata','The CBI has registered a fresh case against Kanpur-based Rotomac Global Private Limited, its promoter Vikram Kothari and other directors for allegedly cheating the Bank of India (BoI) of about 806.75 crore. Among those named as accused are Mr Kotharis wife Sadhna and their son Rahul, as the company directors.')";
			String insertquery14 = "insert into scam values(14,'INX Media','Media','Karti Chidambaram',2020,3000,'Delhi','INX Media, founded by media entrepreneurs Indrani Mukerjea along with husband Peter Mukerjea, allegedly violated foreign investment laws. INX Media had permission to source foreign investments to the tune of 4.62 crore but it has allegedly received funds worth 305 crore.')";
			String insertquery15 = "insert into scam values(15,'Army Recruitment Scam','Army','MVSNA Bagawan',2020,400,'Delhi','The army recruitment scam was basically about clearing temporarily rejected candidates of the army by fraudulently passing them in the medical review. ... Col Surender Singh had received a bribe in exchange for the selection of 10 to 15 candidates.')";
			String insertquery16 = "insert into scam values(16,'VazeGate Scam','Business','Barambir Singh',2020,100,'Mumbai','An unprecedented scandal has hit the Mumbai Police following the arrest of its now-suspended API Sachin Vaze in the Antilia bomb scare probe by the NIA and the alleged murder of Mansukh Hiren, the owner of the gelatin sticks-laden car that was parked near Mukesh Ambanis residence. ')";
			String insertquery17 = "insert into scam values(17,'Oil and Food Scam','Food','Adithya Khanna',2015,6000,'Delhi','The wheels of bureaucracy grind slowly. It has been three weeks since the Union Government announced the setting up of the Justice R.S. Pathak Inquiry Authority to probe the allegations of kickbacks in the Volcker Report against former external affairs minister K. Natwar Singh and the Congress party, and he still has no office.')";
			String insertquery18 = "insert into scam values(18,'2G Spectrum Scam','Telecom','A Raja',2001,17600,'Delhi','In 2008, 122 new second-generation 2G Unified Access Service (UAS) licenses were granted to telecom companies on a first-come, first-served basis at the 2001 price. According to the CBI charge sheet, several laws were violated and bribes were paid to favour certain firms in granting 2G spectrum licenses.')";
			String insertquery19 = "insert into scam values(19,'Bofor Scam','Radio and BroadCast','Bofor AB',1980,500,'Delhi','The scandal relates to illegal kickbacks paid in a US14-billion deal between the Swedish arms manufacturer Bofors with the government of India for the sale of 410 field howitzer guns, and a supply contract almost twice that amount.However, none of the newspapers in India were aware of this.')";
			String insertquery20 = "insert into scam values(20,'Coal Gate Scam','Coal','Madhu Koda',2012,10000,'Jharkhand','India has been a witness to several national level scams by the public officials. The Coalgate scam was one such scam where the UPA Government was accused of allocating coal blocks without the process of competitive bidding. These coal blocks are usually allocated to enterprises after an auction with the highest bidder acquiring the possession of the block.')";

			Statement st = connect.createStatement();
			st.execute(insertquery1);
			st.execute(insertquery2);
			st.execute(insertquery3);
			st.execute(insertquery4);
			st.execute(insertquery5);
			st.execute(insertquery6);
			st.execute(insertquery7);
			st.execute(insertquery8);
			st.execute(insertquery9);
			st.execute(insertquery10);
			st.execute(insertquery11);
			st.execute(insertquery12);
			st.execute(insertquery13);
			st.execute(insertquery14);
			st.execute(insertquery15);
			st.execute(insertquery16);
			st.execute(insertquery17);
			st.execute(insertquery18);
			st.execute(insertquery19);
			st.execute(insertquery20);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
