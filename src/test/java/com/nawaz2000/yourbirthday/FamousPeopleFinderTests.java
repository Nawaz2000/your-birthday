package com.nawaz2000.yourbirthday;

import com.nawaz2000.yourbirthday.helpers.FamousPeopleFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FamousPeopleFinderTests {

    @Test
    @DisplayName("Check correction of wiki page parsing")
    void parseWikiPageTextTest () {
        LocalDate date = LocalDate.of(1986,10,21);
        String wikiPageText = "{{pp-pc1}}\n" +
                "{{pp-move-indef}}\n" +
                "{{calendar}}\n" +
                "{{This date in recent years}}\n" +
                "{{Day}}<!--DO NOT PUT STUFF ABOUT THE END OF THE WORLD IT DID NOT OCCUR-->\n" +
                "\n" +
                "==Events==\n" +
                "===Pre-1600===\n" +
                "*[[1096]] &ndash; A Seljuk Turkish army successfully fights off the [[People's Crusade]].\n" +
                "*[[1097]] &ndash; [[First Crusade]]: Crusaders led by [[Godfrey of Bouillon]], [[Bohemond I of Antioch|Bohemund of Taranto]], and [[Raymond IV, Count of Toulouse]], begin the [[Siege of Antioch]].\n" +
                "*[[1392]] &ndash; Japanese [[Emperor Go-Kameyama]] abdicates in favor of rival claimant [[Emperor Go-Komatsu|Go-Komatsu]].\n" +
                "*[[1512]] &ndash; [[Martin Luther]] joins the theological faculty of the [[Martin Luther University of Halle-Wittenberg|University of Wittenberg]].\n" +
                "*[[1520]] &ndash; [[Ferdinand Magellan]] discovers a strait now known as the [[Strait of Magellan]].\n" +
                "*  1520   &ndash; [[João Álvares Fagundes]] discovers the islands of [[Saint Pierre and Miquelon]], bestowing them their original name of \"Islands of the 11,000 Virgins\".\n" +
                "*[[1600]] &ndash; [[Tokugawa Ieyasu]] defeats the leaders of rival Japanese clans in the [[Battle of Sekigahara]] and becomes shōgun of Japan.\n" +
                "===1601–1900===\n" +
                "*[[1774]] &ndash; The [[flag of Taunton, Massachusetts]] is the first to include the word \"Liberty\".\n" +
                "*[[1797]] &ndash; In [[Boston Harbor]], the 44-gun [[United States Navy]] frigate {{USS|Constitution}} is launched.\n" +
                "*[[1805]] &ndash; [[Napoleonic Wars]]: A British fleet led by [[Horatio Nelson, 1st Viscount Nelson|Lord Nelson]] defeats a combined French and Spanish fleet under [[Pierre-Charles Villeneuve|Admiral Villeneuve]] in the [[Battle of Trafalgar]].\n" +
                "*[[1824]] &ndash; [[Portland cement]] is patented.\n" +
                "*[[1854]] &ndash; [[Florence Nightingale]] and a staff of 38 nurses are sent to the [[Crimean War]].\n" +
                "*[[1861]] &ndash; American Civil War: Union forces under Colonel Edward Baker are [[Battle of Ball's Bluff|defeated]] by Confederate troops in the second major battle of the war. \n" +
                "*[[1867]] &ndash; The [[Medicine Lodge Treaty]] is signed by southern [[Plains Indians|Great Plains Indian]] leaders. The treaty requires Native American Plains tribes to relocate to a reservation in the western [[Indian Territory]].\n" +
                "*[[1879]] &ndash; [[Thomas Edison]] applies for a patent for his design for an [[incandescent light bulb]]. \n" +
                "*[[1888]] &ndash; The [[Social Democratic Party of Switzerland|Swiss Social Democratic Party]] is founded.\n" +
                "*[[1892]] &ndash; Opening ceremonies for the [[World's Columbian Exposition]] are held in Chicago, though because construction was behind schedule, the exposition did not open until May 1, 1893.\n" +
                "*[[1895]] &ndash; The [[Republic of Formosa]] collapses as Japanese forces invade.\n" +
                "===1901–present===\n" +
                "*[[1907]] &ndash; The [[1907 Qaratog earthquake]] hits the borders of Uzbekistan and Tajikistan, killing between 12,000 and 15,000 people.\n" +
                "*[[1910]] &ndash; {{HMS|Niobe|1897|6}} arrives in [[Halifax Harbour]] to become the first ship of the [[Royal Canadian Navy]].\n" +
                "*[[1921]] &ndash; President [[Warren G. Harding]] delivers the first speech by a sitting U.S. president against [[Lynching in the United States|lynching]] in the [[Deep South]].\n" +
                "*[[1931]] &ndash; A secret society in the [[Imperial Japanese Army]] launches an abortive [[October incident|coup d'état attempt]].\n" +
                "*[[1940]] &ndash; The first edition of the [[Ernest Hemingway]] novel ''[[For Whom the Bell Tolls]]'' is published.\n" +
                "*[[1943]] &ndash; [[World War II]]: The [[Azad Hind|Provisional Government of Free India]] is formally established in [[Japanese occupation of Singapore|Japanese-occupied Singapore]].\n" +
                "*[[1944]] &ndash; World War II: The first kamikaze attack damages {{HMAS|Australia|D84|6}} as the [[Battle of Leyte Gulf]] begins.\n" +
                "*  1944   &ndash; World War II: The [[Nemmersdorf massacre]] against German civilians takes place.\n" +
                "*  1944   &ndash; World War II: The city of [[Battle of Aachen|Aachen falls]] to American forces after three weeks of fighting, the first German city to fall to the Allies.\n" +
                "*[[1945]] &ndash; In the [[1945 French legislative election]] French women vote for the first time. \n" +
                "*[[1950]] &ndash; Korean War: Heavy fighting begins between British and Australian forces and North Koreans during the [[Battle of Yongju]].\n" +
                "*[[1956]] &ndash; The [[Mau Mau Uprising]] in Kenya is defeated.\n" +
                "*[[1959]] &ndash; In New York City, the [[Solomon R. Guggenheim Museum]] opens to the public.\n" +
                "*  1959   &ndash; President [[Dwight D. Eisenhower]] approves the transfer of all [[United States Army|US Army]] space-related activities to [[NASA]], including most of the [[Army Ballistic Missile Agency]].\n" +
                "*[[1965]] &ndash; [[Comet Ikeya–Seki]] approaches perihelion, passing 450,000 kilometers (279,617 miles) from the sun.\n" +
                "*[[1966]] &ndash; A colliery spoil tip [[Aberfan disaster|slips onto houses and a school in the village of Aberfan]] in Wales, killing 144 people, 116 of whom were schoolchildren.<ref>{{cite web |title=Aberfan: The mistake that cost a village its children |url=https://www.bbc.co.uk/news/resources/idt-150d11df-c541-44a9-9332-560a19828c47 |website=www.bbc.co.uk |access-date=12 November 2020}}</ref>\n" +
                "*[[1967]] &ndash; The [[National Mobilization Committee to End the War in Vietnam]] organizes a march of fifty thousand people from the Lincoln Memorial to the Pentagon.\n" +
                "*[[1969]] &ndash; The [[1969 Somali coup d'état]] establishes a Marxist–Leninist administration.\n" +
                "*[[1971]] &ndash; A [[Clarkston explosion|gas explosion]] kills 22 people at a shopping centre near Glasgow, Scotland.\n" +
                "*[[1973]] &ndash; [[Fred Dryer]] of the Los Angeles Rams becomes the first player in NFL history to score two safeties in the same game.\n" +
                "*[[1978]] &ndash; Australian civilian pilot [[Disappearance of Frederick Valentich|Frederick Valentich vanishes]] over the [[Bass Strait]] south of [[Melbourne]], after reporting contact with an unidentified aircraft.<ref name=CSICOP>{{cite web |last=Nickell |first=Joe |title=The Valentich Disappearance: Another UFO Cold Case Solved|url=http://www.csicop.org/si/show/the_valentich_disappearance_another_ufo_cold_case_solved |work=Volume 37.6, November/December 2013 |publisher=Committee for Skeptical Inquiry|access-date=14 March 2014}}</ref>\n" +
                "*[[1979]] &ndash; [[Moshe Dayan]] resigns from the Israeli government because of strong disagreements with Prime Minister [[Menachem Begin]] over policy towards the Arabs.\n" +
                "*[[1981]] &ndash; [[Andreas Papandreou]] becomes Prime Minister of Greece, ending an almost 50-year-long system of power dominated by conservative forces.\n" +
                "*[[1983]] &ndash; The [[metre]] is defined as the distance light travels in a vacuum in 1/299,792,458 of a second.\n" +
                "*[[1984]] &ndash; [[Niki Lauda]] claims his third and final [[Formula One]] [[List of Formula One World Drivers' Champions|Drivers' Championship Title]] by half a point ahead of [[McLaren]] team-mate [[Alain Prost]] at the [[1984 Portuguese Grand Prix|Portuguese Grand Prix]].<ref>{{Cite web|title=1984 Portuguese Grand Prix race report|url=https://www.motorsportmagazine.com/archive/article/november-1984/76/another-mclaren-double|access-date=2021-05-17|website=Motor Sport Magazine|language=en-GB}}</ref>\n" +
                "*[[1986]] &ndash; In Lebanon, pro-Iran kidnappers claim to have [[Iran–Contra affair|abducted]] American writer Edward Tracy (he is released in August 1991).\n" +
                "*[[1987]] &ndash; The [[Jaffna hospital massacre]] is carried out by Indian peacekeeping forces in Sri Lanka, killing 70 Tamil patients, doctors and nurses.\n" +
                "*[[1989]] &ndash; In [[Honduras]], 131 people are killed when a [[Boeing 727]] [[Tan-Sahsa Flight 414|crashes]] on approach to [[Toncontín International Airport]] near the nation's capital [[Tegucigalpa]].<ref>{{Cite web|last=Ranter|first=Harro|title=ASN Aircraft accident Boeing 727-224 N88705 Tegucigalpa-Toncontin Airport (TGU)|url=https://aviation-safety.net/database/record.php?id=19891021-0|url-status=live|access-date=2021-10-21|website=aviation-safety.net|publisher=[[Aviation Safety Network]]}}</ref>\n" +
                "*[[1994]] &ndash; North Korea and the United States sign an [[Agreed Framework]] that requires North Korea to stop its nuclear weapons program and agree to inspections.\n" +
                "*  1994   &ndash; In Seoul, South Korea, 32 people are killed when a span of the [[Seongsu Bridge]] collapses.<ref>{{Cite web|url=http://nema.go.kr/eng/m4_seongsu.jsp|archive-url=https://web.archive.org/web/20060303221333/http://nema.go.kr/eng/m4_seongsu.jsp|url-status=dead|archive-date=2006-03-03|title=Collapse of Seongsu Bridge|publisher=National Emergency Management Agency|date=2006|access-date=March 3, 2006}}</ref>\n" +
                "*[[2005]] &ndash; Images of the dwarf planet [[136199 Eris|Eris]] are taken and subsequently used in documenting its discovery.\n" +
                "*[[2011]] – [[Iraq War]]: President [[Barack Obama]] announces that the [[Withdrawal of United States troops from Iraq (2007–2011)|withdrawal of United States troops from Iraq]] will be complete by the end of the year.<ref>{{Cite web|date=2016-10-07|title=Barack Obama - Key Events {{!}} Miller Center|url=https://millercenter.org/president/barack-obama/key-events|access-date=2022-01-11|website=millercenter.org|language=en}}</ref> \n" +
                "*[[2019]] &ndash; Thirty people are killed in a fiery bus crash in western [[Democratic Republic of the Congo]].<ref>{{cite web|website=AA, World, Africa|title=30 killed in bus accident in western DR Congo|date=Oct 21, 2019|url=https://www.aa.com.tr/en/africa/30-killed-in-bus-accident-in-western-dr-congo/1620656}}</ref>\n" +
                "*  2019   &ndash; In [[Canada]], the [[2019 Canadian federal election]] ends, resulting in incumbent Prime Minister [[Justin Trudeau]] remaining in office, albeit with the [[Liberal Party of Canada|Liberal Party]] in a [[minority government]].<ref>{{Cite news|last=Connolly|first=Amanda|date=21 October 2019|title=Justin Trudeau’s Liberals will form a minority government|work=Global News|url=https://globalnews.ca/news/6061385/federal-election-2019-result/|access-date=20 October 2021}}</ref><ref>{{Cite news|last=Brewster|first=Murray|date=22 October 2019|title=The voting is over, now the hard part begins for a minority government|work=CBC News|url=https://www.cbc.ca/news/politics/election-minority-government-function-1.5329358|access-date=20 October 2021}}</ref>\n" +
                "\n" +
                "==Births==\n" +
                "===Pre-1600===\n" +
                "*[[1328]] &ndash; [[Hongwu Emperor]] of China (d. 1398)\n" +
                "*[[1409]] &ndash; [[Alessandro Sforza]], Italian condottiero (d. 1473)<ref name=\"dbi\">[http://www.treccani.it/Portale/elements/categoriesItems.jsp?pathFile=/sites/default/BancaDati/Dizionario_Biografico_degli_Italiani/Italiani_M_Z/BIOGRAFIE_-_EDICOLA_S_160121.xml ‘Sfòrza, Alessandro, signore di Pesaro’], ''Dizionario Biografico degli Italiani''.</ref>\n" +
                "*[[1449]] &ndash; [[George Plantagenet, 1st Duke of Clarence]], Irish-English son of [[Cecily Neville, Duchess of York]] (d. 1478)\n" +
                "*[[1527]] &ndash; [[Louis I, Cardinal of Guise]] (d. 1578)\n" +
                "*[[1536]] &ndash; [[Joachim Ernest, Prince of Anhalt]] (d. 1586)\n" +
                "*[[1581]] &ndash; [[Domenichino]], Italian painter (d. 1641)\n" +
                "===1601–1900===\n" +
                "*[[1650]] &ndash; [[Jean Bart]], French admiral (d. 1702)\n" +
                "*[[1658]] &ndash; [[Henri de Boulainvilliers]], French nobleman (d. 1722)\n" +
                "*[[1675]] &ndash; [[Emperor Higashiyama]] of Japan (d. 1710)\n" +
                "*[[1687]] &ndash; [[Nicolaus I Bernoulli]], Swiss mathematician and theorist (d. 1759)\n" +
                "*[[1712]] &ndash; [[James Steuart (economist)|James Steuart]], Scottish economist and author (d. 1780)\n" +
                "*[[1725]] &ndash; [[Franz Moritz von Lacy]], Austrian field marshal (d. 1801)\n" +
                "*[[1757]] &ndash; [[Pierre Augereau]], French general (d. 1816)\n" +
                "*[[1762]] &ndash; [[Herman Willem Daendels]], Dutch general, lawyer, and politician, 36th [[Governor-General of the Dutch East Indies]] (d. 1818)\n" +
                "*[[1772]] &ndash; [[Samuel Taylor Coleridge]], English poet, philosopher, and critic (d. 1834)\n" +
                "*[[1775]] &ndash; [[Giuseppe Baini]], Italian priest, composer, and critic (d. 1844)\n" +
                "*[[1790]] &ndash; [[Alphonse de Lamartine]], French poet and politician, [[French Head of State]] (d. 1869)\n" +
                "*[[1809]] &ndash; [[James Clark (Jesuit)|James Clark]], American Jesuit (d. 1885)<ref>{{Cite book|last=Mendizàbal|first=Rufo|url=https://jesuitarchives.omeka.net/items/show/826|title=Catalogus defunctorum in renata Societate Iesu ab a. 1814 ad a. 1970|year=1972|location=Rome|pages=91–122|language=la|trans-title=Catalogue of the dead in a revival of the Society of Jesus from 1814 to 1970|oclc=884102|access-date=February 22, 2022|archive-url=https://web.archive.org/web/20211019104247/https://jesuitarchives.omeka.net/items/show/826|archive-date=October 19, 2021|url-status=live|via=Jesuit Archives}}</ref>\n" +
                "*[[1811]] &ndash; [[Filippo Colini]], Italian operatic baritone (d. 1863)\n" +
                "*[[1821]] &ndash; [[Sims Reeves]], English tenor and actor (d. 1900)\n" +
                "*[[1833]] &ndash; [[Alfred Nobel]], Swedish chemist and engineer, invented [[dynamite]] and founded the [[Nobel Prize]] (d. 1896)\n" +
                "*[[1845]] &ndash; [[Will Carleton]], American poet and journalist (d. 1912)\n" +
                "*[[1847]] &ndash; [[Giuseppe Giacosa]], Italian poet and playwright (d. 1906)\n" +
                "*[[1851]] &ndash; [[George Ulyett]], English cricketer and footballer (d. 1898) \n" +
                "*[[1868]] &ndash; [[Ernest Swinton]], British Army officer (d. 1951)\n" +
                "*[[1874]] &ndash; [[Tan Kah Kee]], Chinese businessman, community leader, communist and philanthropist (d. 1961)\n" +
                "*[[1877]] &ndash; [[Oswald Avery]], Canadian-American physician and microbiologist (d. 1955)\n" +
                "*[[1884]] &ndash; [[Claire Waldoff]], German singer and actress (d. 1957)\n" +
                "*[[1886]] &ndash; [[Eugene Burton Ely]], American soldier and pilot (d. 1911)\n" +
                "*[[1887]] &ndash; [[Krishna Singh (politician)|Krishna Singh]], Indian lawyer and politician, 1st [[Chief Minister of Bihar]] (d. 1961)\n" +
                "*[[1894]] &ndash; [[Edogawa Ranpo]], Japanese author and critic (d. 1965)\n" +
                "*[[1895]] &ndash; [[Paavo Johansson]], Finnish javelin thrower and decathlete (d. 1983)\n" +
                "*  1895   &ndash; [[Edna Purviance]], American actress (d. 1958)\n" +
                "*[[1896]] &ndash; [[Esther Shumiatcher-Hirschbein]], Russian-Canadian poet and screenwriter (d. 1985)\n" +
                "*[[1898]] &ndash; [[Eduard Pütsep]], Estonian wrestler and actor (d. 1960)\n" +
                "*[[1900]] &ndash; [[Andrée Boisson]], French Olympic fencer (d. 1973)\n" +
                "\n" +
                "===1901–present===\n" +
                "*[[1902]] &ndash; [[Eddy Hamel]], American footballer (d. [[1943]] in Auschwitz)<ref>Simon Kuper (2012). [https://www.google.com/books/edition/Ajax_the_Dutch_the_War/VC1aclsVRDgC?hl=en&gbpv=1&dq=Eddy+Hamel+October+21,+1902&pg=PA54&printsec=frontcover ''Ajax, the Dutch, the War; The Strange Tale of Soccer During Europe's Darkest Hour'']</ref>\n" +
                "*[[1907]] &ndash; [[Nikos Engonopoulos]], Greek painter and poet (d. 1985)\n" +
                "*[[1908]] &ndash; [[Niyazi Berkes]], Cypriot-English sociologist and academic (d. 1988)\n" +
                "*[[1911]] &ndash; [[Mary Blair]], American illustrator and animator (d. 1978)\n" +
                "*[[1912]] &ndash; [[Don Byas]], American saxophonist and educator (d. 1972)\n" +
                "*  1912   &ndash; [[Alfredo Pián]], Argentinian race car driver (d. 1990)\n" +
                "*  1912   &ndash; [[Georg Solti]], Hungarian-English conductor and director (d. 1997)\n" +
                "*[[1914]] &ndash; [[Martin Gardner]], American mathematician and author (d. 2010)\n" +
                "*[[1915]] &ndash; [[Owen Bradley]], American country music record producer (d. 1998)\n" +
                "*[[1917]] &ndash; [[Dizzy Gillespie]], American trumpet player, composer, and bandleader (d. 1993)\n" +
                "*[[1918]] &ndash; [[Milton Himmelfarb]], American sociologist and author (d. 2006)\n" +
                "*  1918   &ndash; [[Albertina Sisulu]], South African anti-apartheid activist (d. 2011)\n" +
                "*[[1919]] &ndash; [[Jim Wallwork]], English-Canadian sergeant and pilot (d. 2013)\n" +
                "*[[1921]] &ndash; [[Malcolm Arnold]], English composer (d. 2006)\n" +
                "*  1921   &ndash; [[Bruce Beeby]], Australian-English actor (d. 2013)\n" +
                "*  1921   &ndash; [[Robert Clothier]], Canadian actor (d. 1999) \n" +
                "*  1921   &ndash; [[Jim Shumate]], American fiddler and composer (d. 2013)\n" +
                "*  1921   &ndash; [[Ingrid van Houten-Groeneveld]], Dutch astronomer and academic (d. 2015)\n" +
                "*[[1922]] &ndash; [[Liliane Bettencourt]], French businesswoman and philanthropist (d. 2017)\n" +
                "*[[1923]] &ndash; [[Samuel Khachikian]], Iranian director, screenwriter, and author (d. 2001)\n" +
                "*[[1924]] &ndash; [[Joyce Randolph]], American actress\n" +
                "*  1924   &ndash; [[Julie Wilson]], American actress and singer (d. 2015)\n" +
                "*[[1925]] &ndash; [[Celia Cruz]], Cuban-American singer (d. 2003)\n" +
                "*  1925   &ndash; [[Virginia Zeani]], Romanian soprano and educator\n" +
                "*[[1926]] &ndash; [[Bob Rosburg]], American golfer (d. 2009)\n" +
                "*  1926   &ndash; [[Leonard Rossiter]], English actor (d. 1984)\n" +
                "*[[1927]] &ndash; [[Fritz Wintersteller]], Austrian mountaineer (d. 2018)\n" +
                "*  1927   &ndash; [[Howard Zieff]], American director and photographer (d. 2009)\n" +
                "*[[1928]] &ndash; [[Whitey Ford]], American baseball player and coach (d. 2020)\n" +
                "*  1928   &ndash; [[Eudóxia Maria Froehlich]], Brazilian zoologist (d. 2015)\n" +
                "*  1928   &ndash; [[Vern Mikkelsen]], American basketball player and coach (d. 2013)\n" +
                "*[[1929]] &ndash; [[Pierre Bellemare]], French radio and television host (d. 2018)\n" +
                "*  1929   &ndash; [[Fritz Hollaus]], Austrian footballer (d. 1994)\n" +
                "*  1929   &ndash; [[Ursula K. Le Guin]], American author and critic (d. 2018)\n" +
                "*[[1930]] &ndash; [[Ivan Silayev]], Russian engineer and politician, 19th [[Prime Minister of Russia]]\n" +
                "*[[1931]] &ndash; [[Shammi Kapoor]], Indian actor and director (d. 2011)\n" +
                "*  1931   &ndash; [[Jim Parks junior]], English cricketer and manager\n" +
                "*[[1932]] &ndash; [[Pál Csernai]], Hungarian footballer and manager (d. 2013)\n" +
                "*[[1933]] &ndash; [[Maureen Duffy]], English author, poet, and playwright\n" +
                "*  1933   &ndash; [[Francisco Gento]], Spanish footballer and manager (d. 2022)\n" +
                "*[[1935]] &ndash; [[Derek Bell (musician)|Derek Bell]], Irish harp player, pianist, and songwriter (d. 2002)\n" +
                "*  1935   &ndash; [[Mel Street]], American country music singer-songwriter and guitarist (d. 1978)\n" +
                "*[[1937]] &ndash; [[Said Afandi al-Chirkawi]], Russian spiritual leader and scholar (d. 2012)\n" +
                "*  1937   &ndash; [[Hank Nelson]], Australian historian and academic (d. 2012)\n" +
                "*[[1938]] &ndash; [[Carl Brewer (ice hockey)|Carl Brewer]], Canadian ice hockey player (d. 2001)\n" +
                "*[[1940]] &ndash; [[Geoffrey Boycott]], English cricketer and sportscaster\n" +
                "*  1940   &ndash; [[Frances FitzGerald (journalist)|Frances FitzGerald]], American journalist and author\n" +
                "*  1940   &ndash; [[Rhoda Gemignani]], American actress\n" +
                "*  1940   &ndash; [[Manfred Mann (musician)|Manfred Mann]], South African-English keyboard player and producer \n" +
                "*  1940   &ndash; [[Marita Petersen]], Faroese educator and politician, [[Prime Minister of the Faroe Islands]] (d. 2001)\n" +
                "*[[1941]] &ndash; [[Steve Cropper]], American guitarist, songwriter, producer, and actor \n" +
                "*[[1942]] &ndash; [[Elvin Bishop]], American singer-songwriter and guitarist\n" +
                "*  1942   &ndash; [[Allan Grice]], Australian race car driver and politician\n" +
                "*  1942   &ndash; [[Lou Lamoriello]], American ice hockey player, coach, and manager\n" +
                "*  1942   &ndash; [[Judy Sheindlin]], American judge and television host\n" +
                "*  1942   &ndash; [[Christopher A. Sims]], American economist and statistician, [[Nobel Memorial Prize in Economic Sciences|Nobel Prize]] laureate \n" +
                "*  1942   &ndash; [[John Stevens, Baron Stevens of Kirkwhelpington]], English police officer and academic\n" +
                "*[[1943]] &ndash; [[Tariq Ali]], Pakistani historian and author\n" +
                "*  1943   &ndash; [[Ron Elliott (musician)|Ron Elliott]], American singer-songwriter, guitarist, and composer \n" +
                "*[[1944]] &ndash; [[Mandy Rice-Davies]], English model and actress (d. 2014)\n" +
                "*  1944   &ndash; [[Michael Tugendhat]], English lawyer and judge\n" +
                "*[[1945]] &ndash; [[Nikita Mikhalkov]], Russian filmmaker\n" +
                "*  1945   &ndash; [[Michael White (journalist)|Michael White]], English journalist\n" +
                "*[[1946]] &ndash; [[Jane Heal]], English philosopher and academic\n" +
                "*  1946   &ndash; [[Jim Hill (American football)|Jim Hill]], American football player and sportscaster\n" +
                "*  1946   &ndash; [[Lux Interior]], American singer-songwriter (d. 2009)\n" +
                "*  1946   &ndash; [[Lee Loughnane]], American singer-songwriter and trumpet player \n" +
                "*[[1948]] &ndash; [[Shaye J. D. Cohen]], American historian and academic\n" +
                "*  1948   &ndash; [[Allen Henry Vigneron]], American archbishop\n" +
                "*[[1949]] &ndash; [[Michel Brière]], Canadian ice hockey player (d. 1971)\n" +
                "*  1949   &ndash; [[Mike Keenan]], Canadian ice hockey player and coach\n" +
                "*  1949   &ndash; [[Benjamin Netanyahu]], Israeli captain and politician, 9th [[Prime Minister of Israel]]\n" +
                "*[[1950]] &ndash; [[Ronald McNair]], American physicist and astronaut (d. 1986)<ref>{{cite web |title=Space Shuttle Challenger Fast Facts |url=https://edition.cnn.com/2013/09/15/us/space-shuttle-challenger-fast-facts/index.html |website=CNN |access-date=4 December 2021}}</ref>\n" +
                "*  1950   &ndash; [[Leela Vernon]], Belizean musician and cultural conservationist (d. 2017)<ref>{{Cite web|url=https://amandala.com.bz/news/eulogy-leela-vernon/|title=Eulogy for Leela Vernon|date=2017-03-04|website=Amandala Newspaper|language=en-US|access-date=2019-01-03}}</ref>\n" +
                "*[[1952]] &ndash; [[Patti Davis]], American actress and author\n" +
                "*  1952   &ndash; [[Allen Hoey]], American poet and author\n" +
                "*  1952   &ndash; [[Brent Mydland]], German-American keyboard player (d. 1990)\n" +
                "*[[1953]] &ndash; [[Charlotte Caffey]], American guitarist and songwriter\n" +
                "*  1953   &ndash; [[Eric Faulkner]], Scottish singer-songwriter and guitarist\n" +
                "*  1953   &ndash; [[Keith Green]], American singer-songwriter, pianist, and minister (d. 1982)\n" +
                "*  1953   &ndash; [[Marc Johnson (musician)|Marc Johnson]], American bassist, composer, and bandleader\n" +
                "*  1953   &ndash; [[Peter Mandelson]], English journalist and politician, [[Secretary of State for Northern Ireland]]\n" +
                "*[[1954]] &ndash; [[Brian Tobin]], Canadian journalist and politician, 6th [[Premier of Newfoundland]]\n" +
                "*[[1955]] &ndash; [[Dick DeVos]], American businessman\n" +
                "*  1955   &ndash; [[Fred Hersch]], American pianist and composer\n" +
                "*  1955   &ndash; [[Rich Mullins]], American singer-songwriter (d. 1997)\n" +
                "*[[1956]] &ndash; [[Carrie Fisher]], American actress and screenwriter (d. 2016)\n" +
                "*  1956   &ndash; [[Mike Tully]], American pole vaulter\n" +
                "*[[1957]] &ndash; [[Julian Cope]], English singer-songwriter\n" +
                "*  1957   &ndash; [[Irene Edgar]], Scottish lawn bowler<ref>{{cite web |title=Glasgow 2014 - Irene EDGAR Profile |url=http://results.glasgow2014.com/athlete/cycling_road/1026888/irene_edgar.html |website=results.glasgow2014.com |access-date=30 October 2020}}</ref>\n" +
                "*  1957   &ndash; [[Wolfgang Ketterle]], German physicist and academic, [[Nobel Prize in Physics|Nobel Prize]] laureate\n" +
                "*  1957   &ndash; [[Steve Lukather]], American singer-songwriter, guitarist, and producer \n" +
                "*[[1958]] &ndash; [[Andre Geim]], Russian-English physicist and academic, [[Nobel Prize in Physics|Nobel Prize]] laureate\n" +
                "*[[1959]] &ndash; [[George Bell (outfielder)|George Bell]], Dominican baseball player\n" +
                "*  1959   &ndash; [[Rose McDowall]], Scottish singer-songwriter and guitarist \n" +
                "*  1959   &ndash; [[Andy Picheta]], English director, producer, and screenwriter\n" +
                "*  1959   &ndash; [[Kevin Sheedy (Irish footballer)|Kevin Sheedy]], Welsh-Irish footballer and manager\n" +
                "*  1959   &ndash; [[Ken Watanabe]], Japanese actor and producer\n" +
                "*[[1962]] &ndash; [[David Campese]], Australian rugby player and coach\n" +
                "*[[1964]] &ndash; [[Jon Carin]], American singer-songwriter, guitarist, and producer \n" +
                "*[[1965]] &ndash; [[Ion Andoni Goikoetxea]], Spanish footballer and manager\n" +
                "*  1965   &ndash; [[Horace Hogan]], American wrestler\n" +
                "*  1965   &ndash; [[Hisashi Imai]], Japanese singer-songwriter and guitarist \n" +
                "*[[1966]] &ndash; [[Phillip Price]], Welsh golfer\n" +
                "*  1966   &ndash; [[Igor Prins]], Estonian footballer and manager\n" +
                "*  1966   &ndash; [[Arne Sandstø]], Norwegian footballer and manager\n" +
                "*[[1967]] &ndash; [[Georgi Dakov]], Bulgarian high jumper (d. 1996)\n" +
                "*  1967   &ndash; [[Paul Ince]], English footballer and manager\n" +
                "*  1967   &ndash; [[Gavin Lovegrove]], New Zealand javelin thrower and graphic designer\n" +
                "*[[1968]] &ndash; [[Alexandros Alexandris]], Greek footballer and manager\n" +
                "*  1968   &ndash; [[Kerstin Andreae]], German politician\n" +
                "*[[1969]] &ndash; [[Michael Hancock (rugby league)|Michael Hancock]], Australian rugby league player\n" +
                "*  1969   &ndash; [[Mo Lewis]], American football player\n" +
                "*[[1970]] &ndash; [[Louis Koo]], Hong Kong actor and singer\n" +
                "*[[1971]] &ndash; [[Hal Duncan]], Scottish author and poet\n" +
                "*  1971   &ndash; [[Damien Martyn]], Australian cricketer\n" +
                "*  1971   &ndash; [[Nick Oliveri]], American singer-songwriter and bass player\n" +
                "*  1971   &ndash; [[Conor O'Shea]], Irish rugby player and coach\n" +
                "*  1971   &ndash; [[Paul Telfer (footballer)|Paul Telfer]], Scottish footballer and coach\n" +
                "*  1971   &ndash; [[Thomas Ulsrud]], Norwegian curler\n" +
                "*[[1972]] &ndash; [[Matthew Friedberger]], American singer-songwriter and guitarist \n" +
                "*  1972   &ndash; [[Orlando Thomas]], American football player (d. 2014)\n" +
                "*  1972   &ndash; [[Evhen Tsybulenko]], Ukrainian scholar and academic\n" +
                "*  1972   &ndash; [[Ashutosh Agashe]], Indian businessman and cricketer\n" +
                "*[[1973]] &ndash; [[Lera Auerbach]], Russian-American pianist and composer\n" +
                "*  1973   &ndash; [[Charlie Lowell]], American pianist and songwriter \n" +
                "*[[1974]] &ndash; [[Costel Busuioc]], Romanian tenor\n" +
                "*[[1975]] &ndash; [[Toby Hall]], American baseball player\n" +
                "*  1975   &ndash; [[Henrique Hilário]], Portuguese footballer\n" +
                "*[[1976]] &ndash; [[Henrik Gustavsson]], Swedish footballer\n" +
                "*  1976   &ndash; [[Jeremy Miller]], American actor and singer\n" +
                "*  1976   &ndash; [[Lavinia Miloșovici]], Romanian gymnast\n" +
                "*  1976   &ndash; [[Josh Ritter]], American singer-songwriter and guitarist\n" +
                "*  1976   &ndash; [[Mélanie Turgeon]], Canadian skier\n" +
                "*[[1978]] &ndash; [[Joey Harrington]], American football player and sportscaster\n" +
                "*  1978   &ndash; [[Henrik Klingenberg]], Finnish singer and keyboard player \n" +
                "*[[1979]] &ndash; [[Khalil Greene]], American baseball player\n" +
                "*  1979   &ndash; [[Gabe Gross]], American baseball player\n" +
                "*[[1980]] &ndash; [[Kim Kardashian]], American reality television personality, actress, model, businesswoman and socialite\n" +
                "*  1980   &ndash; [[Brian Pittman]], American bass player \n" +
                "*[[1981]] &ndash; [[Martin Castrogiovanni]], Argentinian-Italian rugby player\n" +
                "*  1981   &ndash; [[Nemanja Vidić]], Serbian footballer\n" +
                "*[[1982]] &ndash; [[Matt Dallas]], American actor \n" +
                "*  1982   &ndash; [[Jim Henderson (baseball)|Jim Henderson]], American baseball player\n" +
                "*  1982   &ndash; [[Antony Kay]], English footballer\n" +
                "*  1982   &ndash; [[Hari Kondabolu]], American comedian, actor, and podcaster\n" +
                "*  1982   &ndash; [[Ray Ventrone]], American football player\n" +
                "*  1982   &ndash; [[Lee Chong Wei]], Malaysian badminton player\n" +
                "*  1982   &ndash; [[James White (basketball)|James White]], American basketball player\n" +
                "*[[1983]] &ndash; [[Casey Fien]], American baseball player\n" +
                "*  1983   &ndash; [[Zack Greinke]], American baseball player\n" +
                "*  1983   &ndash; [[Brent Hayden]], Canadian swimmer<ref>{{cite web|title=Brent Hayden|url=https://www.olympic.org/brent-hayden|publisher=International Olympic Committee|access-date=20 May 2020}}</ref>\n" +
                "*  1983   &ndash; [[Gonzalo Klusener]], Argentinian footballer\n" +
                "*  1983   &ndash; [[Andy Marte]], Dominican baseball player (d. 2017)\n" +
                "*  1983   &ndash; [[Amber Rose]], American model\n" +
                "*  1983   &ndash; [[Chris Sherrington]], English-Scottish martial artist\n" +
                "*  1983   &ndash; [[Ninet Tayeb]], Israeli singer\n" +
                "*  1983   &ndash; [[Shelden Williams]], American basketball player\n" +
                "*[[1984]] &ndash; [[Anna Bogdanova]], Russian heptathlete\n" +
                "*  1984   &ndash; [[Tom Brandstater]], American football player\n" +
                "*  1984   &ndash; [[Kenny Cooper]], American soccer player\n" +
                "*  1984   &ndash; [[Anouk Leblanc-Boucher]], Canadian speed skater\n" +
                "*  1984   &ndash; [[José Lobatón]], Venezuelan baseball player\n" +
                "*  1984   &ndash; [[Marvin Mitchell]], American football player\n" +
                "*  1984   &ndash; [[Kieran Richardson]], English footballer\n" +
                "*[[1985]] &ndash; [[Simone Bracalello]], Italian footballer\n" +
                "*  1985   &ndash; [[Dean Collis]], Australian rugby league player\n" +
                "*[[1986]] &ndash; [[Almen Abdi]], Swiss footballer\n" +
                "*  1986   &ndash; [[Chibuzor Chilaka]], Nigerian footballer\n" +
                "*  1986   &ndash; [[Scott Rendell]], English footballer\n" +
                "*[[1987]] &ndash; [[Justin De Fratus]], American baseball player\n" +
                "*  1987   &ndash; [[Andrey Grechin]], Russian swimmer\n" +
                "*[[1988]] &ndash; [[Ricki Olsen]], Danish footballer\n" +
                "*  1988   &ndash; [[Daniel Schorn]], Austrian cyclist\n" +
                "*[[1989]] &ndash; [[Mads Dahm]], Norwegian footballer\n" +
                "*  1989   &ndash; [[Luke Murphy]], English footballer\n" +
                "*  1989   &ndash; [[Jonathan Viera]], Spanish footballer\n" +
                "*  1989   &ndash; [[Sam Vokes]], English-Welsh footballer\n" +
                "*[[1990]] &ndash; [[Bengali-Fodé Koita]], French footballer\n" +
                "*  1990   &ndash; [[Mathieu Peybernes]], French footballer\n" +
                "*  1990   &ndash; [[Ricky Rubio]], Spanish basketball player\n" +
                "*[[1991]] &ndash; [[Tom Eastman]], English footballer\n" +
                "*  1991   &ndash; [[Geoffry Hairemans]], Belgian footballer\n" +
                "*  1991   &ndash; [[Rob Keogh]], English cricketer\n" +
                "*  1991   &ndash; [[Vadaine Oliver]], English footballer\n" +
                "*  1991   &ndash; [[Harry Pell]], English footballer\n" +
                "*[[1992]] &ndash; [[Marzia Bisognin]], Italian businessperson and former YouTuber\n" +
                "*  1992   &ndash; [[Bernard Tomic]], German-Australian tennis player\n" +
                "*[[1993]] &ndash; [[Kane Brown]], American singer and songwriter<ref>{{Cite web|url=https://tasteofcountry.com/tags/kane-brown/|title=KANE BROWN|date=2015-11-09|website=TASTE OF COUNTRY|language=en-US|access-date=2015-11-09}}</ref>\n" +
                "*[[1995]] &ndash; [[Cameron Burgess]], Scottish-Australian footballer\n" +
                "*  1995   &ndash; [[Antoinette Guedia Mouafo]], Cameroonian swimmer\n" +
                "*  1995   &ndash; [[Doja Cat]], American rapper, singer and songwriter<ref>{{Cite web|title=24-year-old Doja Cat is this month's 'One To Watch' Artist!|url=https://www.kissradio.ca/2020/03/02/doja-cat-is-this-months-one-to-watch-artist/|access-date=2020-11-13|website=www.kissradio.ca}}</ref>\n" +
                "<!--Please do not add yourself, non-notable people, fictional characters, or people without Wikipedia articles to this list. No red links, please. Do not link multiple occurrences of the same year, just link the first occurrence. If there are multiple people in the same birth year, put them in alphabetical order. Do not trust \"this year in history\" websites for accurate date information.-->\n" +
                "\n" +
                "==Deaths==\n" +
                "===Pre-1600===\n" +
                "* [[645]] &ndash; [[Zhenzhu Khan]], khan of [[Xueyantuo]]\n" +
                "*[[1023]] &ndash; [[Gero (archbishop of Magdeburg)|Gero]], Archbishop of Magdeburg\n" +
                "*[[1096]] &ndash; [[Walter Sans Avoir]], a leader of the [[First Crusade]]\n" +
                "*[[1125]] &ndash; [[Cosmas of Prague]], Bohemian priest and historian (b. 1045)\n" +
                "*[[1204]] &ndash; [[Robert de Beaumont, 4th Earl of Leicester]], English politician\n" +
                "*[[1221]] &ndash; [[Alix, Duchess of Brittany]] (b. 1201)\n" +
                "*[[1266]] &ndash; [[Birger Jarl]], Swedish politician (b. 1210)\n" +
                "*[[1314]] &ndash; [[Geoffrey de Geneville, 1st Baron Geneville]]\n" +
                "*[[1422]] &ndash; [[Charles VI of France]] (b. 1368)\n" +
                "*[[1500]] &ndash; [[Emperor Go-Tsuchimikado]] of Japan (b. 1442)\n" +
                "*[[1505]] &ndash; [[Paul Scriptoris]], German mathematician and educator (b. 1460)\n" +
                "*[[1556]] &ndash; [[Pietro Aretino]], Italian author (b. 1492)\n" +
                "*[[1558]] &ndash; [[Julius Caesar Scaliger]], Italian physician and scholar (b. 1484)\n" +
                "*[[1600]] &ndash; [[Ōtani Yoshitsugu]], Japanese samurai (b. 1558)\n" +
                "===1601–1900===\n" +
                "*[[1623]] &ndash; [[William Wade (English politician)|William Wade]], English politician and diplomat, [[Lieutenant of the Tower of London]] (b. 1546)\n" +
                "*[[1662]] &ndash; [[Henry Lawes]], English pianist and composer (b. 1595)\n" +
                "*[[1687]] &ndash; [[Edmund Waller]], English poet and politician (b. 1606)\n" +
                "*[[1765]] &ndash; [[Giovanni Paolo Panini]], Italian painter and architect (b. 1691)\n" +
                "*[[1775]] &ndash; [[Peyton Randolph]], American lawyer and politician, 1st [[President of the Continental Congress]] (b. 1721)\n" +
                "*[[1777]] &ndash; [[Samuel Foote]], English actor and playwright (b. 1720)\n" +
                "*[[1805]] &ndash; [[John Cooke (Royal Navy officer)|John Cooke]], English captain (b. 1763)<ref>{{Cite book|last1=White|first1=Colin|author1-link=Colin White (historian)|others=The [[1805 Club]]|title=The Trafalgar Captains: Their Lives and Memorials|year=2005|publisher=[[Lionel Leventhal|Chatham Publishing]]|page=48|location=London|language=en|isbn=978-1-86176-247-4|oclc=469507654}}</ref>\n" +
                "*  1805   &ndash; [[George Duff]], Scottish captain (b. 1764)\n" +
                "*  1805   &ndash; [[Horatio Nelson, 1st Viscount Nelson]], English admiral (b. 1758)\n" +
                "*[[1821]] &ndash; [[Dorothea Ackermann]], German actress (b. 1752)\n" +
                "*[[1835]] &ndash; [[Muthuswami Dikshitar]], Indian poet and composer (b. 1775)\n" +
                "*[[1861]] &ndash; [[Edward Dickinson Baker]], American congressman and colonel (b. 1811)\n" +
                "*[[1872]] &ndash; [[Jacques Babinet]], French physicist, mathematician, and astronomer (b. 1794)\n" +
                "*[[1873]] &ndash; [[Johan Sebastian Welhaven]], Norwegian author, poet, and critic (b. 1807)\n" +
                "*[[1896]] &ndash; [[James Henry Greathead]], South African-English engineer (b. 1844)\n" +
                "===1901–present===\n" +
                "*[[1903]] &ndash; [[Jinmaku Kyūgorō]], Japanese sumo wrestler, the 12th [[Makuuchi#Yokozuna|Yokozuna]] (b. 1829)\n" +
                "*[[1904]] &ndash; [[Isabelle Eberhardt]], Swiss explorer and journalist (b. 1877)\n" +
                "*[[1907]] &ndash; [[Jules Chevalier]], French priest, founded the [[Missionaries of the Sacred Heart]] (b. 1824)\n" +
                "*[[1931]] &ndash; [[Arthur Schnitzler]], Austrian author and playwright (b. 1862)\n" +
                "*[[1938]] &ndash; [[Dorothy Hale]], American actress (b. 1905)\n" +
                "*[[1940]] &ndash; [[William G. Conley]], American journalist, lawyer, and politician, 18th [[Governor of West Virginia]] (b. 1866)\n" +
                "*[[1941]] &ndash; [[Alexander Greenlaw Hamilton]], Australian biologist (b. 1852)\n" +
                "*[[1944]] &ndash; [[Alois Kayser]], German-French missionary (b. 1877)\n" +
                "*[[1952]] &ndash; [[Hans Merensky]], South African geologist and philanthropist (b. 1871)\n" +
                "*[[1963]] &ndash; [[Józef Franczak]], Polish sergeant (b. 1918)\n" +
                "*[[1965]] &ndash; [[Bill Black]], American bass player and bandleader (b. 1926)\n" +
                "*[[1969]] &ndash; [[Jack Kerouac]], American novelist and poet (b. 1922)\n" +
                "*  1969   &ndash; [[Wacław Sierpiński]], Polish mathematician and academic (b. 1882)\n" +
                "*[[1970]] &ndash; [[Li Linsi]], Chinese educator and diplomat (b. 1896)\n" +
                "*[[1971]] &ndash; [[Minnie Evans]], American artist (b. 1888)\n" +
                "*[[1973]] &ndash; [[Nasif Estéfano]], Argentinian race car driver (b. 1932)\n" +
                "*[[1975]] &ndash; [[Charles Reidpath]], American runner and general (b. 1887)\n" +
                "*[[1977]] &ndash; [[Ferit Tüzün]], Turkish composer (b. 1929)\n" +
                "*[[1978]] &ndash; [[Anastas Mikoyan]], Armenian-Russian civil servant and politician (b. 1895)\n" +
                "*[[1980]] &ndash; [[Hans Asperger]], Austrian physician and psychologist (b. 1906)\n" +
                "*[[1982]] &ndash; [[Radka Toneff]], Norwegian singer-songwriter (b. 1952)\n" +
                "*[[1983]] &ndash; [[Joseph P. Lordi]], American government official (b. 1919)\n" +
                "*[[1984]] &ndash; [[François Truffaut]], French actor, director, producer, and screenwriter (b. 1932)\n" +
                "*[[1985]] &ndash; [[Dan White]], American assassin and politician (b. 1946)\n" +
                "*[[1986]] &ndash; [[Lionel Murphy]], Australian jurist and politician, 22nd [[Attorney-General of Australia]] (b. 1922)\n" +
                "*[[1989]] &ndash; [[Jean Image]], Hungarian-French director, producer, and screenwriter (b. 1910)\n" +
                "*[[1990]] &ndash; [[Dany Chamoun]], Lebanese engineer and politician (b. 1934)\n" +
                "*  1990   &ndash; [[Prabhat Ranjan Sarkar]], Indian spiritual guru, philosopher and author (b. 1921)\n" +
                "*[[1991]] &ndash; [[Lorenc Antoni]], Albanian composer, conductor, and musicologist (b. 1909)\n" +
                "*[[1992]] &ndash; [[Ante Ciliga]], Croatian politician, writer and publisher (b. 1898)\n" +
                "*  1992   &ndash; [[Jim Garrison]], American lawyer and judge (b. 1921)\n" +
                "*[[1993]] &ndash; [[Sam Zolotow]], American journalist and critic (b. 1899)\n" +
                "*[[1995]] &ndash; [[Maxene Andrews]], American singer (b. 1916)\n" +
                "*  1995   &ndash; [[Jesús Blasco]], Spanish author and illustrator (b. 1919)\n" +
                "*  1995   &ndash; [[Nancy Graves]], American sculptor and painter (b. 1939)\n" +
                "*  1995   &ndash; [[Shannon Hoon]], American singer-songwriter and guitarist (b. 1967)\n" +
                "*[[1996]] &ndash; [[Georgios Zoitakis]], Greek general and politician (b. 1910)\n" +
                "*[[1998]] &ndash; [[Francis W. Sargent]], American soldier and politician, 64th [[Governor of Massachusetts]] (b. 1915)\n" +
                "*[[1999]] &ndash; [[Lars Bo]], Danish author and illustrator (b. 1924)\n" +
                "*  1999   &ndash; [[Ahmet Taner Kışlalı]], Turkish political scientist, lawyer, and politician (b. 1939)\n" +
                "*[[2002]] &ndash; [[Edward J. Mortola]], American academic and president of Pace University (b. 1917)<ref name=\"NYT2002\">{{cite news |last1=Saxon|first1=Wolfgang |title=Edward Mortola, 85; Oversaw Expansion at Pace |url=https://www.nytimes.com/2002/10/29/nyregion/edward-mortola-85-oversaw-expansion-at-pace.html |newspaper=The New York Times |date=October 29, 2002 |access-date=February 5, 2017 |language=en}}</ref>\n" +
                "*[[2003]] &ndash; [[Louise Day Hicks]], American politician (b. 1916)\n" +
                "*  2003   &ndash; [[Luis A. Ferré]], Puerto Rican engineer and politician, 3rd [[Governor of Puerto Rico]] (b. 1904)\n" +
                "*  2003   &ndash; [[Elliott Smith]], American singer-songwriter and guitarist (b. 1969)\n" +
                "*[[2006]] &ndash; [[Sandy West]], American singer-songwriter and drummer  (b. 1959)\n" +
                "*[[2007]] &ndash; [[Paul Fox (musician)|Paul Fox]], English singer-songwriter and guitarist (b. 1951)\n" +
                "*[[2010]] &ndash; [[A. Ayyappan]], Indian poet and translator (b. 1949)\n" +
                "*[[2011]] &ndash; [[Hikmet Bilâ]], Turkish journalist and author (b. 1954)\n" +
                "*  2011   &ndash; [[Tone Pavček]], Slovenian poet and author (b. 1928)\n" +
                "*[[2012]] &ndash; [[Yash Chopra]], Indian director, producer, and screenwriter (b. 1932)\n" +
                "*  2012   &ndash; [[Antoni Dobrowolski]], Polish educator (b. 1904)\n" +
                "*  2012   &ndash; [[Jaroslav Kozlík]], Czech volleyball player and educator (b. 1907)\n" +
                "*  2012   &ndash; [[Alf Kumalo]], South African photographer and journalist (b. 1930)\n" +
                "*  2012   &ndash; [[George McGovern]], American historian, lieutenant, and politician (b. 1922)\n" +
                "*[[2013]] &ndash; [[Bud Adams]], American businessman (b. 1923)\n" +
                "*  2013   &ndash; [[Gianni Ferrio]], Italian composer and conductor (b. 1924)\n" +
                "*  2013   &ndash; [[Rune T. Kidde]], Danish author, poet, and illustrator (b. 1957)\n" +
                "*  2013   &ndash; [[Colonel Robert Morris]], American singer-songwriter and drummer (b. 1954)\n" +
                "*  2013   &ndash; [[Major Owens]], American librarian and politician (b. 1936)\n" +
                "*  2013   &ndash; [[Tony Summers]], Welsh swimmer (b. 1924)\n" +
                "*  2013   &ndash; [[Oscar Yanes]], Venezuelan journalist and author (b. 1927)\n" +
                "*[[2014]] &ndash; [[Ben Bradlee]], American journalist and author (b. 1921)\n" +
                "*  2014   &ndash; [[Nelson Bunker Hunt]], American businessman (b. 1926)\n" +
                "*  2014   &ndash; [[Mohammad-Reza Mahdavi Kani]], Iranian cleric and politician, [[Prime Minister of Iran]] (b. 1931)\n" +
                "*  2014   &ndash; [[Edith Kawelohea McKinzie]], Hawaiian genealogist, author, and hula expert (b. 1925)\n" +
                "*  2014   &ndash; [[Gough Whitlam]], Australian lieutenant, lawyer, and politician, 21st [[Prime Minister of Australia]] (b. 1916)\n" +
                "*[[2015]] &ndash; [[France Bučar]], Slovenian lawyer and politician (b. 1923)\n" +
                "*  2015   &ndash; [[Marty Ingels]], American actor (b. 1936)\n" +
                "*  2015   &ndash; [[Norman W. Moore]], English conservationist and author (b. 1923)\n" +
                "*  2015   &ndash; [[Sheldon Wolin]], American philosopher, theorist, and academic (b. 1922)\n" +
                "* [[2020]] &ndash; [[Frank Bough]], English television presenter (b. 1933)<ref>{{Cite news|date=2020-10-25|title=Obituary: Frank Bough|language=en-GB|work=BBC News|url=https://www.bbc.com/news/entertainment-arts-26063499|access-date=2020-12-13}}</ref>\n" +
                "* [[2021]] &ndash; [[Bernard Haitink]], Dutch conductor and violinist. (b. 1929)<ref>[https://www.bbc.com/news/entertainment-arts-59002746 Bernard Haitink: Celebrated classical conductor dies at 92], BBC News, October 22, 2021</ref>\n" +
                "<!--Do not add people without Wikipedia articles to this list. Do not trust \"this year in history\" websites for accurate date information. Do not link multiple occurrences of the same year, just link the first occurrence.-->\n" +
                "\n" +
                "==Holidays and observances==\n" +
                "*[[Apple Day]] ([[United Kingdom]])\n" +
                "*[[Public holidays in Honduras|Armed Forces Day]] ([[Honduras]])\n" +
                "*Christian [[feast day]]:\n" +
                "**[[Asterius of Ostia]]\n" +
                "**[[Berthold of Parma]]\n" +
                "**Blessed [[Charles I of Austria|Charles of Austria]]  ([[Roman Catholic Church]])\n" +
                "**[[Fintán of Taghmon]]\n" +
                "**[[Hilarion]]\n" +
                "**[[John of Bridlington]]\n" +
                "**[[Laura of Saint Catherine of Siena]]\n" +
                "**[[Saint Leticia|Leticia]]\n" +
                "**[[Malchus of Syria]]\n" +
                "**[[Peter Yu Tae-chol]]\n" +
                "**[[Severinus of Bordeaux]]\n" +
                "** [[Tuda of Lindisfarne]]\n" +
                "**[[Saint Ursula|Ursula]]\n" +
                "**[[Viator of Lyons]]\n" +
                "**[[October 21 (Eastern Orthodox liturgics)]]\n" +
                "*[[Public holidays in Egypt|Egyptian Naval Day]] ([[Egypt]])\n" +
                "*[[Central Reserve Police Force|Indian Police Commemoration Day]] ([[India]])\n" +
                "*[[National Nurses' Day]] ([[Thailand]])\n" +
                "*[[Ndadaye Day]] ([[Burundi]])\n" +
                "*[[Overseas Chinese Day]] ([[Republic of China]])\n" +
                "*[[Trafalgar Day]] (the [[British Empire]] in the 19th and early 20th century)\n" +
                "*[[Twin Holy Birthdays|Birth of the Báb (2017)]] ([[Baháʼí Faith]])\n" +
                "\n" +
                "== References ==\n" +
                "{{reflist}}\n" +
                "\n" +
                "==External links==\n" +
                "{{commons}}\n" +
                "* {{cite web |url=http://news.bbc.co.uk/onthisday/hi/dates/stories/october/21 |title=On This Day |publisher=BBC}}\n" +
                "* {{NYT On this day|month=10|day=21}}\n" +
                "* {{cite web |url=https://www.onthisday.com/events/october/21 |title=Historical Events on October 21 |publisher=OnThisDay.com}}\n" +
                "* {{cite web |url=http://canadachannel.ca/todayincanadianhistory/index.php/October_21 |title=Today in Canadian History |publisher=Canada Channel}}\n" +
                "\n" +
                "{{months}}\n" +
                "\n" +
                "{{DEFAULTSORT:October 21}}\n" +
                "[[Category:Days of the year]]\n" +
                "[[Category:October]]\n";
        List<String> expected = new ArrayList<>();

        expected.add("1986;;Almen Abdi;;Swiss footballer");
        expected.add("1986;;Chibuzor Chilaka;;Nigerian footballer");
        expected.add("1986;;Scott Rendell;;English footballer");

        FamousPeopleFinder famousPeopleFinder = new FamousPeopleFinder();
        List<String> actual = famousPeopleFinder.parseWikiPageText(wikiPageText, date);

        assertEquals(expected,actual);
    }

    //birthStrToWikiPerson(String birthStr)


}
