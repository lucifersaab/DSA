package Fakers;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class faker extends revenue_faker {
    String[] names = {
            "Abbas", "Abdullah", "Abid", "Adnan", "Afzal", "Ahmad", "Akbar", "Akram", "Ali", "Amin",
            "Amir", "Anwar", "Arif", "Asad", "Ashfaq", "Asif", "Asim", "Atif", "Aurangzeb", "Awais",
            "Ayaz", "Azam", "Azhar", "Aziz", "Babar", "Bashir", "Basit", "Bilal", "Daud", "Ejaz",
            "Faisal", "Faiz", "Faizan", "Farhan", "Farooq", "Farukh", "Fateh", "Fazal", "Feroz", "Ghaffar",
            "Ghulam", "Habib", "Hafeez", "Haji", "Hakim", "Hamid", "Hamza", "Hanif", "Haris", "Hasan",
            "Hassan", "Ibrahim", "Idrees", "Iftikhar", "Ijaz", "Imran", "Iqbal", "Irfan", "Irshad", "Ishtiaq",
            "Jabbar", "Jalal", "Jamal", "Jameel", "Jamshed", "Javed", "Jawad", "Junaid", "Kaleem", "Kamal",
            "Kamran", "Kashif", "Khalid", "Khurram", "Khwaja", "Liaquat", "Mahmood", "Majid", "Mansoor", "Masood",
            "Mehmood", "Mehmood", "Mian", "Mohammad", "Moin", "Mubarak", "Mubashir", "Muhammad", "Mujahid", "Mukhtar",
            "Munawar", "Mushtaq", "Mustafa", "Nadeem", "Naeem", "Nasir", "Nawaz", "Nazir", "Noman", "Nasrullah",
            "Obaid", "Qasim", "Qazi", "Qayyum", "Rafiq", "Rahim", "Rahman", "Rais", "Raja", "Rashid",
            "Rehan", "Riaz", "Saeed", "Saif", "Salim", "Samad", "Samir", "Sarfraz", "Sattar", "Shabbir",
            "Shafiq", "Shahid", "Shakeel", "Shakir", "Shams", "Shamshad", "Sharif", "Shehzad", "Shoaib", "Sikandar",
            "Sohail", "Sultan", "Tahir", "Talat", "Tanveer", "Tariq", "Tasleem", "Tauseef", "Usman", "Wahab",
            "Wajid", "Waqar", "Waseem", "Yahya", "Yasir", "Yousaf", "Zafar", "Zahid", "Zahoor", "Zakir",
            "Zameer", "Zulfiqar", "Aasia", "Aasma", "Abeer", "Adeela", "Aisha", "Aleena", "Alia", "Amina",
            "Amna", "Anam", "Anila", "Anum", "Aqsa", "Arifa", "Arzoo", "Asiya", "Atiya", "Ayesha",
            "Azra", "Bushra", "Farah", "Fareeha", "Farhana", "Farkhanda", "Farzana", "Fatima", "Fauzia", "Fiza",
            "Ghazala", "Gulnaz", "Hadia", "Hafsa", "Haleema", "Hamida", "Hina", "Humaira", "Iram", "Irum",
            "Jamila", "Kalsoom", "Kiran", "Maham", "Mahnoor", "Maliha", "Mamoona", "Maria", "Marium", "Mehwish",
            "Mishal", "Misbah", "Nadia", "Nafeesa", "Nageen", "Naghma", "Naima", "Najma", "Naseem", "Nashra",
            "Naveeda", "Nazia", "Nighat", "Nida", "Nighat", "Nighat", "Nuzhat", "Parveen", "Qudsia", "Rabia",
            "Rafia", "Razia", "Rehana", "Rubina", "Saba", "Sabah", "Sadaf", "Saeeda", "Saima", "Saira",
            "Sajida", "Sakina", "Salma", "Samina", "Sana", "Sara", "Shabnam", "Shaheen", "Shahida", "Shahnaz",
            "Shakeela", "Shamim", "Shazia", "Shireen", "Sobia", "Sultana", "Sumaira", "Sumayya", "Tabassum", "Tahira",
            "Tasneem", "Tayyaba", "Uzma", "Yasmeen", "Zahida", "Zainab", "Zara", "Zareen", "Zubaida", "Abdul", "Abida", "Afshan", "Aisha", "Akhtar", "Aliya", "Amara", "Amjad", "Anila", "Anwar",
            "Arslan", "Ayesha", "Bano", "Basheer", "Bushra", "Danish", "Ejaz", "Farah", "Faraz", "Fareeda",
            "Farida", "Faryal", "Fawad", "Fiza", "Ghazala", "Gul", "Gulshan", "Hafiz", "Haleem", "Hamida",
            "Haniya", "Haroon", "Hassan", "Iqra", "Javed", "Jawaria", "Kamila", "Kashmala", "Kausar", "Khadija",
            "Khalida", "Khurram", "Kinza", "Mahira", "Maqsood", "Marium", "Mehmood", "Mehnaz", "Mehwish", "Misbah",
            "Mohsin", "Mubarak", "Mubashira", "Mudassir", "Mujtaba", "Mumtaz", "Munir", "Mustafa", "Nadia", "Naeem",
            "Naheed", "Najma", "Nargis", "Naseem", "Nasir", "Nazia", "Nusrat", "Parveen", "Qamar", "Qasim",
            "Quratulain", "Rabia", "Rafi", "Rahat", "Raisa", "Rashida", "Rehana", "Rizwan", "Rubina", "Saba",
            "Sabira", "Sabrina", "Saeeda", "Safia", "Sajida", "Sakina", "Salma", "Samina", "Sanam", "Sarwar",
            "Seema", "Shabana", "Shahida", "Shakeela", "Shama", "Shazia", "Shireen", "Sobia", "Sohail", "Sumaira",
            "Sumera", "Tahir", "Tariq", "Tasnim", "Tayyaba", "Umar", "Uzma", "Wajahat", "Waseem", "Yasmeen",
            "Yasir", "Zafar", "Zahida", "Zahra", "Zain", "Zakia", "Zara", "Zehra", "Zeeshan",
            "Abbas", "Adil", "Aftab", "Ameer", "Anwar", "Arif", "Asad", "Ashfaq", "Asif",
            "Asim", "Aurangzeb", "Awais", "Ayaz", "Azam", "Azhar", "Aziz", "Babar", "Bilal",
            "Faisal", "Farhan", "Fazal", "Ghulam", "Habib", "Hameed", "Hamid", "Hamza", "Haris",
            "Hasan", "Imran", "Irfan", "Jalal", "Jameel", "Jamshed", "Kamran", "Kashif", "Khalid",
            "Majeed", "Majid", "Mansoor", "Masood", "Mehboob", "Mehmood", "Moin", "Mukhtar", "Mushtaq",
            "Mustafa", "Nadeem", "Nasir", "Nawaz", "Noman", "Nasrullah", "Obaid", "Qasim", "Qazi",
            "Rafiq", "Rahim", "Rahman", "Rais", "Raja", "Rashid", "Rehan", "Riaz", "Saeed",
            "Saif", "Salim", "Samad", "Sarfraz", "Shabbir", "Shafiq", "Shahid", "Shakeel", "Shakir",
            "Shams", "Sharif", "Shehzad", "Shoaib", "Sikandar", "Sohail", "Sultan", "Tahir", "Talat",
            "Tanveer", "Tariq", "Tasleem", "Tauseef", "Usman", "Wahab", "Wajid", "Waqar", "Waseem",
            "Yahya", "Yasir", "Yousaf", "Zafar", "Zahid", "Zahoor", "Zakir", "Zameer", "Zulfiqar",
            "Abbasi", "Ahmed", "Ali", "Amin", "Anwar", "Arif", "Ashraf", "Aslam", "Baig", "Bajwa",
            "Bashir", "Bhatti", "Bukhari", "Butt", "Cheema", "Chishti", "Choudhry", "Durrani", "Farooqi", "Ghauri",
            "Gill", "Haque", "Hassan", "Hussain", "Iqbal", "Jamil", "Javed", "Khan", "Khawaja", "Lodhi",
            "Mahmood", "Malik", "Mirza", "Mohsin", "Nawaz", "Nazir", "Qureshi", "Rashid", "Raza", "Rizvi",
            "Saeed", "Saleem", "Shah", "Sheikh", "Siddiqui", "Tariq", "Warsi", "Younis", "Zafar", "Zaidi",
            "Zaman", "Zubair"

};


    static String[] lastNames = {
            "Abbasi",
            "Ahmed",
            "Akhtar",
            "Ali",
            "Arif",
            "Aslam",
            "Bashir",
            "Chaudhry",
            "Farooq",
            "Hussain",
            "Iqbal",
            "Khan",
            "Malik",
            "Mirza",
            "Mughal",
            "Nadeem",
            "Nawaz",
            "Qureshi",
            "Rana",
            "Rashid",
            "Saeed",
            "Saleem",
            "Sheikh",
            "Shah",
            "Siddiqui",
            "Tariq",
            "Ullah",
            "Waqar",
            "Yousaf",
            "Zafar",
            "Ahmed",
            "Ali",
            "Amir",
            "Bilal",
            "Faisal",
            "Hassan",
            "Imran",
            "Junaid",
            "Kamran",
            "Abbas", "Ahmad", "Akhtar", "Alam", "Ali", "Amir", "Anjum", "Anwar", "Awan", "Aziz",
            "Babar", "Badar", "Baig", "Bajwa", "Bhatti", "Butt", "Cheema", "Choudhary", "Daud", "Durrani",
            "Faisal", "Farid", "Ghani", "Gill", "Hameed", "Haque", "Hussain", "Iqbal", "Javed", "Kamal",
            "Khan", "Khattak", "Lodhi", "Malik", "Masood", "Mirza", "Mohammad", "Nadeem", "Nawaz", "Noor",
            "Qaiser", "Qayyum", "Qureshi", "Rafiq", "Rahman", "Raja", "Rashid", "Raza", "Rehman", "Riaz",
            "Saleem", "Shah", "Sheikh", "Siddiqui", "Tariq", "Usmani", "Warsi", "Yaqoob", "Younus"
    };

    static String[] addresses = {
            "Gulshan Road, Karachi", "Jinnah Avenue, Islamabad", "Mall Road, Lahore", "Main Boulevard, Faisalabad",
            "Shahrah-e-Faisal, Karachi", "Zafar Road, Rawalpindi", "Ferozepur Road, Lahore", "Liaquat Avenue, Hyderabad",
            "Jinnah Road, Quetta", "Garden Street, Peshawar", "Allama Iqbal Road, Multan", "Kashmir Lane, Mirpur",
            "Shahrah-e-Quaid, Karachi", "Islamabad Highway, Rawalpindi", "Model Town Link Road, Lahore",
            "Sarwar Road, Gujranwala", "Bahria Town Boulevard, Islamabad", "DHA Phase 6, Lahore",
            "Ghazi Road, Lahore", "Shara-e-Iqbal, Karachi", "Murree Road, Rawalpindi", "Gulberg Main Boulevard, Lahore",
            "GT Road, Lahore", "Cantt Road, Peshawar", "Shara-e-Faisal, Karachi", "Iqbal Street, Sialkot",
            "Mall Avenue, Lahore", "Circular Road, Abbottabad", "Saddar Bazaar, Rawalpindi",
            "Ravi Road, Lahore", "Link Road, Faisalabad", "Johar Town Main Boulevard, Lahore",
            "Railway Road, Lahore", "KDA Avenue, Karachi", "Clifton Road, Karachi", "University Road, Peshawar",
            "Cavalry Ground Main Boulevard, Lahore", "Jail Road, Lahore", "Sultan Street, Karachi",
            "Shahra-e-Resham, Faisalabad", "Faisalabad Bypass, Faisalabad", "Rahim Yar Khan Road, Rahim Yar Khan",
            "Abbot Road, Lahore", "Muree Road, Murree", "Lyallpur Town Road, Faisalabad", "Peshawar Road, Rawalpindi",
            "Multan Road, Lahore", "M.A Jinnah Road, Karachi", "Katchery Road, Hyderabad",
            "Rawalpindi Cantt Road, Rawalpindi", "University Town Boulevard, Peshawar",
            "Qasim Road, Multan", "Ali Block Main Boulevard, Lahore", "Sargodha Road, Faisalabad",
            "Karachi-Hyderabad Motorway, Karachi", "Satellite Town Road, Rawalpindi",
            "Karim Block Road, Lahore", "Faisal Town Main Boulevard, Lahore", "Murree Expressway, Murree",
            "Bhawalpur Road, Bahawalpur", "Thandi Sarak, Abbottabad", "Sialkot Road, Gujranwala",
            "Sheikhupura Road, Sheikhupura", "Jhelum Road, Jhelum", "Gujranwala Road, Gujrat",
            "G.T Road, Rawalpindi", "Sahiwal Road, Sahiwal", "Lahore-Islamabad Motorway, Lahore",
            "Abbottabad Road, Abbottabad", "Wah Cantt Road, Wah Cantt", "Shara-e-Rashid, Sargodha",
            "Bannu Road, Dera Ismail Khan", "Attock Road, Attock", "Sargodha Bypass, Sargodha",
            "Kohat Road, Peshawar", "Lahore-Sialkot Motorway, Lahore", "Gujrat Road, Gujranwala",
            "Sahiwal-Lodhran Road, Sahiwal", "Gujranwala-Sialkot Road, Gujranwala",
            "Nawabshah-Hyderabad Road, Nawabshah", "Rahim Yar Khan-Lodhran Road, Rahim Yar Khan",
            "Peshawar-Charsadda Road, Peshawar", "Muzaffargarh Road, Muzaffargarh",
            "Kasur-Lahore Motorway, Kasur", "Sargodha-Mianwali Road, Sargodha",
            "Jacobabad-Khairpur Road, Jacobabad", "Mandi Bahauddin Road, Mandi Bahauddin",
            "Shahkot-Nankana Sahib Road, Shahkot", "Malakand Road, Malakand", "Rajanpur-Mianwali Road, Rajanpur",
            "Larkana-Moenjodaro Road, Larkana", "Okara-Vehari Road, Okara", "Jhang-Gojra Road, Jhang",
            "Haveli Lakha-Pattoki Road, Haveli Lakha", "Daharki-Kandhkot Road, Daharki",
            "Sukkur-Rohri Road, Sukkur", "Shakargarh-Narowal Road, Shakargarh",
            "Nowshera-Mardan Road, Nowshera", "Chaman-Quetta Road, Chaman",
            "Gujrat-Kala Shah Kaku Motorway, Gujrat", "Swabi-Mardan Road, Swabi",
            "Nowshehra-Peshawar Motorway, Nowshera", "Layyah-Multan Road, Layyah",
            "Taxila-Khanpur Road, Taxila", "Jampur-Kotla Road, Jampur",
            "Bahawalpur-Bahawalnagar Road, Bahawalpur", "Chishtian-Eidgah Road, Chishtian",
            "Rawalpindi-Sohawa Road, Rawalpindi", "Mirpurkhas-Nawabshah Road, Mirpurkhas",
            "Mian Channu-Kabirwala Road, Mian Channu", "Hassan Abdal-Kot Najibullah Road, Hassan Abdal",
            "Layyah-Dera Ghazi Khan Road, Layyah", "Shakar Dara Road, Shakar Dara"
    };

    static String[] contactNumbers = {
            "0300123456", "0300234567", "0300345678", "0300456789", "0300567890",
            "0300678901", "0300789012", "0300890123", "0300901234", "0301012345",
            "0301123456", "0301234567", "0301345678", "0301456789", "0301567890",
            "0301678901", "0301789012", "0301890123", "0301901234", "0302012345",
            "0302123456", "0302234567", "0302345678", "0302456789", "0302567890",
            "0302678901", "0302789012", "0302890123", "0302901234", "0303012345",
            "0303123456", "0303234567", "0303345678", "0303456789", "0303567890",
            "0303678901", "0303789012", "0303890123", "0303901234", "0304012345",
            "0304123456", "0304234567", "0304345678", "0304456789", "0304567890",
            "0304678901", "0304789012", "0304890123", "0304901234", "0305012345",
            "0305123456", "0305234567", "0305345678", "0305456789", "0305567890",
            "0305678901", "0305789012", "0305890123", "0305901234", "0306012345",
            "0306123456", "0306234567", "0306345678", "0306456789", "0306567890",
            "0306678901", "0306789012", "0306890123", "0306901234", "0307012345",
            "0307123456", "0307234567", "0307345678", "0307456789", "0307567890",
            "0307678901", "0307789012", "0307890123", "0307901234", "0308012345",
            "0308123456", "0308234567", "0308345678", "0308456789", "0308567890",
            "0308678901", "0308789012", "0308890123", "0308901234", "0309012345",
            "0309123456", "0309234567", "0309345678", "0309456789", "0309567890",
            "0309678901", "0309789012", "0309890123", "0309901234", "0310012345",
            "0310123456", "0310234567", "0310345678", "0310456789", "0310567890",
            "0310678901", "0310789012", "0310890123", "0310901234", "0311012345",
            "0311123456", "0311234567", "0311345678", "0311456789", "0311567890",
            "0311678901", "0311789012", "0311890123", "0311901234", "0312012345",
            "0312123456", "0312234567", "0312345678", "0312456789", "0312567890",
            "0312678901", "0312789012", "0312890123", "0312901234", "0313012345",
            "0313123456", "0313234567", "0313345678", "0313456789", "0313567890",
            "0313678901", "0313789012", "0313890123", "0313901234", "0314012345",
            "0314123456", "0314234567", "0314345678", "0314456789", "0314567890",
            "0314678901", "0314789012", "0314890123", "0314901234", "0315012345",
            "0315123456", "0315234567", "0315345678", "0315456789", "0315567890",
            "0315678901", "0315789012", "0315890123", "0315901234", "0316012345",
            "0316123456", "0316234567", "0316345678", "0316456789", "0316567890",
            "0316678901", "0316789012", "0316890123", "0316901234", "0317012345",
            "0317123456", "0317234567", "0317345678", "0317456789", "0317567890",
            "0317678901", "0317789012", "0317890123", "0317901234", "0318012345",
            "0318123456", "0318234567", "0318345678", "0318456789", "0318567890",
            "0318678901", "0318789012", "0318890123", "0318901234", "0319012345",
            "0319123456", "0319234567", "0319345678", "0319456789", "0319567890",
            "0319678901", "0319789012", "0319890123", "0319901234", "0320012345",
            "0320123456", "0320234567", "0320345678", "0320456789", "0320567890",
            "0320678901", "0320789012", "0320890123", "0320901234", "0321012345",
            "0321123456", "0321234567", "0321345678", "0321456789", "0321567890",
            "0321678901", "0321789012", "0321890123", "0321901234", "0322012345",
            "0322123456", "0322234567", "0322345678", "0322456789", "0322567890",
            "0322678901", "0322789012", "0322890123", "0322901234", "0323012345",
            "0323123456", "0323234567", "0323345678", "0323456789", "0323567890",
            "0323678901", "0323789012", "0323890123", "0323901234", "0324012345",
            "0324123456", "0324234567", "0324345678", "0324456789", "0324567890",
            "0324678901", "0324789012", "0324890123", "0324901234", "0325012345",
            "0325123456", "0325234567", "0325345678", "0325456789", "0325567890",
            "0325678901", "0325789012", "0325890123", "0325901234", "0326012345",
            "0326123456", "0326234567", "0326345678", "0326456789", "0326567890",
            "0326678901", "0326789012", "0326890123", "0326901234", "0327012345",
            "0327123456", "0327234567", "0327345678", "0327456789", "0327567890",
            "0327678901", "0327789012", "0327890123", "0327901234", "0328012345",
            "0328123456", "0328234567", "0328345678", "0328456789", "0328567890",
            "0328678901", "0328789012", "0328890123", "0328901234", "0329012345",
            "0329123456", "0329234567", "0329345678", "0329456789", "0329567890",
            "0329678901", "0329789012", "0329890123", "0329901234", "0330012345",
            "0330123456", "0330234567", "0330345678", "0330456789", "0330567890",
            "0330678901", "0330789012", "0330890123", "0330901234", "0331012345",
            "0331123456", "0331234567", "0331345678", "0331456789", "0331567890",
            "0331678901", "0331789012", "0331890123", "0331901234", "0332012345",
            "0332123456", "0332234567", "0332345678", "0332456789", "0332567890",
            "0332678901", "0332789012", "0332890123", "0332901234", "0333012345",
            "0333123456", "0333234567", "0333345678", "0333456789", "0333567890",
            "0333678901", "0333789012", "0333890123", "0333901234", "0334012345"
    };
        public static void main(String[] args) {


            faker obj=new faker();
            LocalDate startDateRange = LocalDate.of(2022, 1, 1);
            LocalDate currentDate = LocalDate.now();

            String[] startDates = new String[410];
            for (int i = 0; i < 410; i++) {
                LocalDate randomDate = startDateRange.plusDays(ThreadLocalRandom.current().nextLong(currentDate.toEpochDay() - startDateRange.toEpochDay() + 1));
                startDates[i] = randomDate.toString();
            }


            LocalDate start_DateRange = LocalDate.of(1970, 1, 1);
            LocalDate endDateRange = LocalDate.of(2000, 12, 31);

            String[] dobs = new String[410];
            for (int i = 0; i < 410; i++) {
                LocalDate randomDate = start_DateRange.plusDays(ThreadLocalRandom.current().nextLong(0, endDateRange.toEpochDay() - start_DateRange.toEpochDay() + 1));
                dobs[i] = randomDate.toString();
            }



            String filePath = "members_data.txt";
            String[] status={"Active","In-Active"};
            try (FileWriter writer = new FileWriter(filePath)) {
                String query = "INSERT INTO Members (id, name, address, contact_info, membership_status, mem_id, mem_start_date, date_of_birth) VALUES ";
                writer.write(query);
                for (int i = 101; i < 510; i++) {
                    String line = String.format(" (%d, '%s', '%s', '%s', '%s', %d, '%s', '%s'),\n",
                            i+1,
                            obj.names[i]+
                           " "+lastNames[i%80],
                            generateRandomNumber(1,999)+" "+addresses[i%100],
                            contactNumbers[i%340]+generateRandomNumber(0,9),
                            status[generateRandomNumber(0,1)],
                            generateRandomNumber(1,3),
                            startDates[i%400],
                             dobs[i%400]);
                    writer.write(line);
                }

                System.out.println("Flat file created successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while creating the flat file: " + e.getMessage());
            }
        }

    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}

