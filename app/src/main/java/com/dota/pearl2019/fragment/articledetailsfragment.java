package com.dota.pearl2019.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dota.pearl2019.R;

public class articledetailsfragment extends Fragment {

    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_text_display, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView display = getActivity().findViewById(R.id.tv_display);
        TextView title = getActivity().findViewById(R.id.morename);
        title.setText("");

        int id;
        Bundle bundle = getActivity().getIntent().getExtras();
        id = bundle.getInt("id1");
        display.setText(getArticles(id));


    }

    private String getArticles(int id) {
        String text = "";
        switch (id) {
            case 0:
                text = "PlayerUnknown’s Battlegrounds\n" +
                        "Popularly abbreviated as PUBG, is an online battle royale game which gained much popularity since its initial launch in late 2017. \n" +
                        "\n" +
                        "The game is now on almost all the popular platforms and due to its wide playerbase many of the good gamers of PUBG started streaming their matches live on platforms like twitch and youtube. Their primary revenue being adverts and super-chats. \n" +
                        "Various organizations decided to cash in on it’s popularity and tournaments are organised at all levels to further boost the game’s popularity and give the elite player-base an incentive to keep playing the game.\n" +
                        "The official PUBG game creators also created a tournament known as “Star Challenge” in which the winning team grabbed a whooping $200,000.Our own college organised one of them during this ATMOS.\n" +
                        "\n" +
                        "DOTA 2 \n" +
                        "DOTA started off as a mod for Warcraft III. It has since gone on to establish itself as one of the (if not the) best MOBAs in the industry. Each player controls a character with unique abilities. As a result of this, a lot of variety and pressure exists in terms of play styles and roles that the characters and thereby the players must use to win. \n" +
                        "The DOTA scene on campus is developing but as of yet, there have been no tournaments unlike CS:GO. But on the international scale serves as the golden standard for e-sports. DOTA and it’s competitor League of Legends boast of massive prize pools and tournament circuit followed by an international league. DOTA’s International 2018 boasted of net prize pool of a whooping 25 and half million dollars. \n" +
                        "\n" +
                        "Counter Strike: Global Offensive \n" +
                        "\n" +
                        "Counter Strike has been a household name for the almost 20 years. Just like DOTA, it started off as a mod for Half Life. Global Offensive followed the very solid, Source. The game is simple, two teams - Counter Terrorists and Terrorists.\n" +
                        "Global Offensive has strong competitive presence on campus, with two tournaments - Fraglore and Overtime; the former during Pearl and latter is new standalone tournament with some success. \n" +
                        " Fraglore is held during Pearl and has two stages - the preliminaries and the finals. The preliminaries consist of an online qualifier for students from other colleges and an on campus qualifier for students participating from BITS-Hyderabad. The finals consist of 11 teams dueling it out for a prize pool of around 11K.\n" +
                        "\n" +
                        "Overtime on the other hand had around 40 participating players. The second year students were captains of teams and other students were auctioned off. It was the first proper gaming tournament held on Campus.\n" +
                        "\n" +
                        "To summarize, the gaming culture on campus is slowly but steadily improving with plans for further improvements in place.\n\nWriters:-\nSanath Salil, Adithya Warrier\nEditor:-\nAbhimanyu Dasgupta";
                break;
            case 1:
                text = "Rising importance of sports culture in technical institutions:-\n" +
                        "All work and no play will not make anyone happy and studying in a university translates to a lot of work which not only involves academic workload but also involves the work an individual does for a club or a department during their time in college. The recent years have seen importance being given to promote sports in colleges, especially engineering colleges. This importance can be attributed to a study that recognized a lack of means for students to vent their stress and as a means to provide a break from their increasing sedentary lifestyles. Playing a sport may help correct this flaw. Not only does playing a sport keep an individual fit, but it also comes with a plethora of other advantages that help inculcate certain quintessential characteristics in an individual’s lifetime. First and the foremost, sports help an individual improve their physical prowess. It teaches them self-discipline and self-control as sportspersons also maintain a rigorous exercise regime and diet. Such a regime makes an individual physically fit and mentally strong. Other than physical effects, sports also inculcate essential life lessons which might be useful at a later point in a person's life. A team sport teaches an individual to work with a team, to be a part of the team. Team building and teamwork are very important for anyone because a corporate work environment involves working with other people for numerous things. Transparent and effective communication is important for any corporate project to succeed and playing sports especially team sports can help improve one's communication skills. Secondly, an individual learns to cope up with losses. In any game, one side wins while the other side loses. One must be prepared to accept defeat. For individuals eyeing to be entrepreneurs, this is very important because facing loss and coping with it is a big part of any successful startup. Sports also teach individuals the art of making strategic tactics and help improve their decision-making skills. In this process, one also gets to learn about their strengths and weaknesses thus giving them a chance to improve themselves. Sports also help improve one's reflexes and improves brain functioning thus allowing individuals to concentrate better and finish academic and non-academic work with greater efficiency. Not to forget the social status that comes with playing a sport; this, in turn, helps in having positive mental health and improves social skills.\n" +
                        "With an increasing number of intercollegiate sports fests, teams from colleges across the country have upped their game. Intercollegiate sports fests have become a platform to showcase the talent that the colleges have. With the inclusion of several unconventional sports in recent times, the fests have been bigger in scale every year. It usually boils down to teams testing out their coordination skills on the field and determining which college team is the best.\n\nWriters:-\nNivedan Vishwanath , Shreejee Goyal\nEditor:-\nAditya Gayatri Sastry Kaipa\t\n";
                break;
            case 3:
                text = "Development in technology is affecting the lifestyle of the present generation. This is a clichéd yet an intriguing statement. Advancement in digital technology has led to the widespread and excessive use of electronic devices, especially in age groups where it should be kept to a bare minimum. There was a time when children of primary and high school used to gather in the evening to play games like tag, where one of the players has to chase the others, hide-and-seek, high-and-low (pahaad-paani), lock-and-key, London statue, capture the flag, etc. Although the names varied from place to place, the gameplay often remained the same. These games possessed the essence of the innocence of that age group. Even now we can find kids playing these outdoor games but their number is almost inconsequential in front of those playing games on smartphones and desktops. Consequently, they lack the minimum amount of physical activity they should be involved in, which affects their mental and physical growth. Some might argue that in the current scenario, interaction with digital technology is inevitable, but we can surely balance it or cut it out at least for entertainment purposes and instead encourage more of physical activity.\n" +
                        "Moving forward, here we have some unconventional sports, the names of which you might not have heard. These sports aren’t much popular but have interesting rules of play. Sepak Takraw or kick volleyball is one such sport mostly played in Southeast Asia. It differs from the sport of foot volley in its use of a rattan ball and only allowing players to use their feet, knee, chest, and head to touch the ball. A similar game originated in Czechoslovakia is known by the name football tennis. Sepak Takraw is a regular event in the Asian games. \n" +
                        "Invented by Dutch performance artist Iepe Rubingh, Chess Boxing is a hybrid that combines two traditional pastimes: chess, a cerebral board game, and boxing, a physical sport. The competitors fight in alternating rounds of chess and boxing. The story behind the birth of this sport is pretty interesting. Rubingh’s idea originates from the 1992 comic Froid Équateur—written by French comic book artist Enki Bilal (born Enes Bilalović)—that portrays a chessboxing world championship. In the comic book version, however, the opponents fight an entire boxing match before they face each other in a game of chess. Finding this to be impractical, Rubingh developed the idea further until it turned into the competitive sport that chessboxing is today with alternating rounds of chess and boxing and a detailed set of rules and regulations. This sport is now particularly popular in Germany, the United Kingdom, India, and Russia and is a part of various competitions.\n" +
                        "Korfball is a ball sport, with similarities to netball and basketball. It is played by two teams of eight players with four females and four males in each team. The objective is to throw a ball into a bottomless basket that is mounted on a 3.5 m  high pole. The sport was invented by Dutch school teacher Nico Broekhuysen in 1902. Four players of each team are in one zone, and the rest are in the other zone. Within each zone, a player may only defend a member of the opposite team of the same gender. At the beginning of the match, one team chooses one-half of the court. That half will be their defending zone, with 'their' basket in it. Players score by throwing the ball through the opponents' basket. After two goals, the teams change zones: defenders become attackers and attackers become defenders. In between those zone-changes, attackers cannot set foot on their defending zone or vice versa. At half-time teams swap halves. The sport is very popular in Belgium and Taiwan and is also played in many other countries.\n" +
                        "Developed by British falconer Scott Mason in 2001, Parahawking is an adventure sport that combines paragliding with falconry. Mason began a round-the-world trip in Pokhara, Nepal, where many birds of prey – such as the griffon vulture, steppe eagle, and black kite – can be found. While taking a tandem paragliding flight with British paraglider Adam Hill, he had the opportunity to see raptors in flight and realized that he could combine the sports of paragliding and falconry. Already in 2010 the Nepalese government announced that the Himalayan Raptor Rescue Centre in Pokhara is to be closed following allegations that it was illegally holding endangered birds and that the parahawking amounted to cruelty. Despite these allegations parahawking stayed operational in Pokhara until 2017.\n" +
                        "In February 2017 Mason announced that parahawking has been shut down\n" +
                        "Hungerball is a football-based hybrid sport played in New Zealand, Australia, Canada, and the UK. Hungerball is played inside an inflatable, fully enclosed arena, featuring six small goals. The game consists of six players, all defending a goal each. One ball is used and players cannot use their hands. Hungerball was created in Auckland, New Zealand. In 2017, Hungerball received the Bronze Award for Innovation in Health & Wellness as part of the Asia-Pacific Stevie Awards.\n" +
                        "Headis is a mix of table tennis and the heading of association football. It is played at a regular table tennis table so it combines the tactical elements of table tennis and the legwork of tennis. It was invented in 2006 by a sports student René Wegner. Two players play at a regular table tennis table and the ball must only make contact with the head. The table, however, can be touched by any part of your body. Playing a volley is allowed as well. After every ball played you have to touch the ground before heading the next ball.\n" +
                        "There are countless other unconventional sports like the ones aforementioned which are yet to see the light of the day. Few changes in the rules and hybridization of two or more sports makes the play more fun and interesting. Some of them require much more than regular setups, making them unconventional to play, but a sports enthusiast must be curious to try them out at some point in time\n\nWriter:-\nAdarsh Mishra\nEditor:-\nVamsi BG\n";
                break;
            case 2:
                text = "The Sports Secretary Interview:-\n" +
                        "With Arena fast approaching, all the sports teams are seen pushing their limits with the hope of proving their mettle in the upcoming tournament. The two main individuals behind this event are the sport secretaries, and fortunately enough we got Sohith Deva (Sports Secretary – Boys) and Kritika Kasliwal (Sports Secretary – Girls) to take time off their hectic schedules and talk to us. We spoke to them about the upcoming fest, and their hopes about the outcome. \n" +
                        "In an attempt to up their game this time, all departments associated with the fest are giving their best. The department of Firewallz initially faced problems with registrations, but they managed to pull back and get a lot of teams registered for Arena. As Sohith elaborated on this issue, the fest dates clashed with university exams across colleges in Hyderabad. What appeared to be a setback initially, led to an increase in registrations by teams from other cities and states, which came as a result of better publicity. But, in the end, the tides turned because the dates for the university examinations got postponed and registrations from local colleges started coming in. As a result, this edition of Arena has more registrations than any other edition. He also informed us about significant cuts in expenditures for the fest which included trophies, tents and other essentials and hopes that the fest will go into profit.\n" +
                        "Both the sport secretaries are happy with team performances in the last semester. The last semester saw football, basketball, badminton and chess teams among many others participating in inter college tournaments and friendly matches and their good performance in these events makes them quite hopeful for Arena as well. Kritika was happy with the way the coaching sessions were utilized last semester. The last semester saw an increase in coaching sessions and the teams made the best use of it. Rigorous drills, practices and skill building sessions helped players learn new tactics and skills over the last semester and we might see them in action in the upcoming fest.\n" +
                        "“You know you have succeeded when a lot of sports have excess registrations” Kritika added, and in fact, some teams had to be rejected simply because there were so many!\n" +
                        "Shifting focus to the participation of girls in Arena, there was a lot of progress. With tennis for girls being introduced last semester, and ultimate frisbee showing a lot of participation from girls, they’re taking their game seriously.\n" +
                        "Sohith also spoke briefly about inclusion of sports like skating and duathlon. They unfortunately, will not able to include ultimate frisbee because of a few problems with the Ultimate Players Association of India. He also conducted pro-am for selecting players for various sports teams but refrained from doing so for football and basketball due to high chances of physical injury to the players.\n" +
                        "Arena has been planned with an awesome lineup of proshows, and other cultural programs as well, including a traditional Kerala fight during republic day and a polish EDM artiste. Both Sohith and Kritika are quite confident that this edition of Arena will be one of the biggest intercollegiate sporting tournaments in the country, and the best one our college has ever hosted. \n\nWriters:-\nRamana Sriram, Nivedan Vishwanath\nEditor:-\nSiddharth Sampath\n";
                break;
            case 4:
                text = "Shreya Deep \n" +
                        "Football\n" +
                        "Ever since I watched the World Cup when I was in the seventh grade, I fell in love with football and developed an eagerness to learn the technicalities. I got the opportunity to do just that when I came to college. My friend, Kritika, had played football in school and in an attempt to spark interest for football among girls, tried to form a girls team in her first year. She went about this by desperately asking around for girls to come forward to play, and by contacting them on the Meera Bhavan WhatsApp group. While 4-5 people did show up on the first day, eventually it was just Kritika and I practicing in the QT. We most often simply passed to each other, as she taught me the basics.\n" +
                        "\n" +
                        "In my first year, the captain of the boys team wanted to improve the football culture on campus, and suggested the introduction of a girls cheerleading squad. Outraged by this, Sajal, another girl in my year, strongly condemned this, and tried to officially set up a girls team. Slowly and steadily, more girls joined us, eventually leading to the formation of a team.\n" +
                        "\n" +
                        "I know that the team has improved immensely since Arena 2018, where we played our first proper match, mostly to gain experience. We also occasionally practice with the boys team and learn from them. They have always been a great help.\n" +
                        "I only wish that the team had been formed sooner but I genuinely believe that building a team from scratch is an impressive achievement in itself, and I am very proud of how far we have come.  \n" +
                        "\n" +
                        "Guna Kaushik \n" +
                        "Kabaddi\n" +
                        "I was introduced to kabaddi by my seniors during interactions in my first year. They taught me the basic movements of the sport, and asked me to play. Although I didn’t choose to pick up the sport initially, after playing for a few days I developed an affinity for it. I improved by observing others’ faults and got into the team as a substitute. I went on to join the team in my second year and made captain in third year.\n" +
                        "\n" +
                        "It's true that the sport is quite aggressive. I have broken both my shoulders in tournaments and have undergone months of physiotherapy, but haven’t let it affect my game. That might be attributed to there being no coach for the team. But the sport follows a hereditary kind of culture. Everyone learns from seniors and then passes on their knowledge to juniors. This has made us a very close knit team, with everyone having immense respect for each other. \n" +
                        "\n" +
                        "\n" +
                        "Sonakshi Gupta\n" +
                        "Tennis\n" +
                        "I have been fascinated by tennis for a long time, and I used to follow it on Television. I wanted to learn it in school but never got the chance to because of academics and a lack of coaching. Somehow, that made me even more determined to learn tennis after coming to college.\n\nWriters:-\nMaithree Venkatesan, Ishita Gupta\nEditor:-\nChatrik Singh Mangat";
                break;

        }
        return text;
    }
}
