package com.hhy.camera.color.teller;

import java.util.ArrayList;

// renk listesi sınıfı
class ColorList {
    private final ArrayList<Color> colors = new ArrayList<>();

    // tüm renkleri tanımla
    // Color(String hexcode, int[] rgb, double[] lab, String name)
    ColorList() {
        int[] rgb1 = {0, 0, 255};
        double[] lab1 = {32.302586667249486, 79.19666178930935, -107.86368104495168};
        Color color1 = new Color("#0000ff", rgb1, lab1, "mavi");
        colors.add(color1);
        int[] rgb2 = {221, 133, 215};
        double[] lab2 = {67.31715390973771, 45.767914042043834, -27.9565727429556};
        Color color2 = new Color("#dd85d7", rgb2, lab2, "lavanta pembesi");
        colors.add(color2);
        int[] rgb3 = {166, 200, 117};
        double[] lab3 = {76.4968662063573, -25.280306276997123, 37.78312525655873};
        Color color3 = new Color("#a6c875", rgb3, lab3, "hafif yosun yeşili");
        colors.add(color3);
        int[] rgb4 = {255, 99, 233};
        double[] lab4 = {66.57098866524055, 73.98291492268255, -38.757586268752185};
        Color color4 = new Color("#ff63e9", rgb4, lab4, "şeker pembesi");
        colors.add(color4);
        int[] rgb5 = {211, 182, 131};
        double[] lab5 = {75.41614887220986, 3.2743111238065503, 29.81875338120814};
        Color color5 = new Color("#d3b683", rgb5, lab5, "çok açık kahverengi");
        colors.add(color5);
        int[] rgb6 = {67, 5, 65};
        double[] lab6 = {13.729976280753252, 35.349474567573175, -21.074257865258993};
        Color color6 = new Color("#430541", rgb6, lab6, "patlıcan moru");
        colors.add(color6);
        int[] rgb7 = {255, 178, 208};
        double[] lab7 = {80.54651897029908, 32.23542258553985, -3.8133398673572128};
        Color color7 = new Color("#ffb2d0", rgb7, lab7, "toz pembe");
        colors.add(color7);
        int[] rgb8 = {196, 142, 253};
        double[] lab8 = {68.14837741331718, 41.369190821804125, -47.7895237772074};
        Color color8 = new Color("#c48efd", rgb8, lab8, "leylak");
        colors.add(color8);
        int[] rgb9 = {255, 250, 134};
        double[] lab9 = {96.55497968695205, -13.599709070628519, 55.78328185607451};
        Color color9 = new Color("#fffa86", rgb9, lab9, "manila");
        colors.add(color9);
        int[] rgb10 = {86, 132, 174};
        double[] lab10 = {53.532218363930255, -3.662060884834284, -27.035157460574432};
        Color color10 = new Color("#5684ae", rgb10, lab10, "kapalı mavi");
        colors.add(color10);
        int[] rgb11 = {0, 147, 55};
        double[] lab11 = {53.105941976918004, -53.301193047439135, 38.61326320539094};
        Color color11 = new Color("#009337", rgb11, lab11, "yeşilimsi");
        colors.add(color11);
        int[] rgb12 = {255, 249, 23};
        double[] lab12 = {95.61101270886167, -18.489559753760766, 91.40035231118264};
        Color color12 = new Color("#fff917", rgb12, lab12, "güneş sarısı");
        colors.add(color12);
        int[] rgb13 = {200, 255, 176};
        double[] lab13 = {94.71024009057484, -31.291966934298422, 32.27626052247699};
        Color color13 = new Color("#c8ffb0", rgb13, lab13, "çok açık yeşil");
        colors.add(color13);
        int[] rgb14 = {255, 243, 154};
        double[] lab14 = {95.03206279490689, -8.231894701209551, 44.327425182239736};
        Color color14 = new Color("#fff39a", rgb14, lab14, "koyu krem");
        colors.add(color14);
        int[] rgb15 = {239, 192, 254};
        double[] lab15 = {83.55051851995026, 27.40347749153638, -24.152834856137105};
        Color color15 = new Color("#efc0fe", rgb15, lab15, "açık lavanta");
        colors.add(color15);
        int[] rgb16 = {246, 104, 142};
        double[] lab16 = {62.882720473013634, 57.71435040100626, 7.119100626632235};
        Color color16 = new Color("#f6688e", rgb16, lab16, "gül pembesi");
        colors.add(color16);
        int[] rgb17 = {33, 56, 171};
        double[] lab17 = {29.643281813873095, 34.4207091437852, -63.59378156667573};
        Color color17 = new Color("#2138ab", rgb17, lab17, "safir mavisi");
        colors.add(color17);
        int[] rgb18 = {252, 246, 121};
        double[] lab18 = {95.15565918682763, -13.916320412265204, 60.02221967664756};
        Color color18 = new Color("#fcf679", rgb18, lab18, "saman sarısı");
        colors.add(color18);
        int[] rgb19 = {29, 2, 0};
        double[] lab19 = {2.751697878746146, 9.784897183770555, 4.301625933457437};
        Color color19 = new Color("#1d0200", rgb19, lab19, "çok koyu kahverengi");
        colors.add(color19);
        int[] rgb20 = {255, 255, 182};
        double[] lab20 = {98.49474610418528, -10.953074775866433, 34.98776931626328};
        Color color20 = new Color("#ffffb6", rgb20, lab20, "krem rengi");
        colors.add(color20);
        int[] rgb21 = {253, 220, 92};
        double[] lab21 = {88.3721872765391, -2.6163720174396388, 65.13813429293253};
        Color color21 = new Color("#fddc5c", rgb21, lab21, "açık altın sarısı");
        colors.add(color21);
        int[] rgb22 = {120, 209, 182};
        double[] lab22 = {77.85810861177751, -33.048001120813296, 5.0683300029987555};
        Color color22 = new Color("#78d1b6", rgb22, lab22, "deniz mavisi");
        colors.add(color22);
        int[] rgb23 = {157, 7, 89};
        double[] lab23 = {34.068801367969705, 59.014125530292446, -4.422520343908531};
        Color color23 = new Color("#9d0759", rgb23, lab23, "koyu fuşya");
        colors.add(color23);
        int[] rgb24 = {153, 0, 250};
        double[] lab24 = {43.76236225882275, 84.31312799407664, -85.68181776833042};
        Color color24 = new Color("#9900fa", rgb24, lab24, "canlı mor");
        colors.add(color24);
        int[] rgb25 = {142, 118, 24};
        double[] lab25 = {50.42126739515133, -0.24145989001689294, 50.628118991742056};
        Color color25 = new Color("#8e7618", rgb25, lab25, "ela");
        colors.add(color25);
        int[] rgb26 = {84, 172, 104};
        double[] lab26 = {63.663374048166204, -41.550362479972904, 27.085869606419678};
        Color color26 = new Color("#54ac68", rgb26, lab26, "yosun yeşili");
        colors.add(color26);
        int[] rgb27 = {202, 255, 251};
        double[] lab27 = {96.4271675134987, -17.424514454553176, -3.598887190543376};
        Color color27 = new Color("#cafffb", rgb27, lab27, "çok açık mavi");
        colors.add(color27);
        int[] rgb28 = {21, 46, 255};
        double[] lab28 = {36.61847446097425, 67.2643807062569, -100.65022786208317};
        Color color28 = new Color("#152eff", rgb28, lab28, "canlı mavi");
        colors.add(color28);
        int[] rgb29 = {171, 126, 76};
        double[] lab29 = {56.18921369535829, 11.572951718824998, 33.80263212411063};
        Color color29 = new Color("#ab7e4c", rgb29, lab29, "açık kahverengi");
        colors.add(color29);
        int[] rgb30 = {104, 0, 24};
        double[] lab30 = {20.07992112729064, 42.16336948914387, 18.512756833887167};
        Color color30 = new Color("#680018", rgb30, lab30, "bordo");
        colors.add(color30);
        int[] rgb31 = {111, 124, 0};
        double[] lab31 = {49.24628358722548, -18.67292946581073, 54.10454309241247};
        Color color31 = new Color("#6f7c00", rgb31, lab31, "nane yeşili");
        colors.add(color31);
        int[] rgb32 = {219, 88, 86};
        double[] lab32 = {54.77381989088222, 51.203806887840045, 27.827165043828682};
        Color color32 = new Color("#db5856", rgb32, lab32, "pastel kırmızı");
        colors.add(color32);
        int[] rgb33 = {169, 3, 8};
        double[] lab33 = {35.03854730908245, 58.583274085053176, 46.01099236763275};
        Color color33 = new Color("#a90308", rgb33, lab33, "koyu kırmızı");
        colors.add(color33);
        int[] rgb34 = {77, 164, 9};
        double[] lab34 = {60.022592643688654, -49.407660023299385, 60.28426112461229};
        Color color34 = new Color("#4da409", rgb34, lab34, "çim rengi");
        colors.add(color34);
        int[] rgb35 = {0, 95, 106};
        double[] lab35 = {36.41398510345226, -19.44144990502669, -13.07024334672614};
        Color color35 = new Color("#005f6a", rgb35, lab35, "petrol mavisi");
        colors.add(color35);
        int[] rgb36 = {118, 255, 123};
        double[] lab36 = {90.23022508879606, -63.04493689861379, 51.44757382177414};
        Color color36 = new Color("#76ff7b", rgb36, lab36, "açık yeşil");
        colors.add(color36);
        int[] rgb37 = {98, 88, 196};
        double[] lab37 = {43.59759341997195, 32.83061569162149, -55.42592276455498};
        Color color37 = new Color("#6258c4", rgb37, lab37, "soluk mavi");
        colors.add(color37);
        int[] rgb38 = {143, 140, 231};
        double[] lab38 = {61.968165682912684, 22.754350846408922, -45.749712524132555};
        Color color38 = new Color("#8f8ce7", rgb38, lab38, "lila");
        colors.add(color38);
        int[] rgb39 = {6, 177, 196};
        double[] lab39 = {66.1118209782153, -30.352705264353684, -20.285943063024735};
        Color color39 = new Color("#06b1c4", rgb39, lab39, "turkuaz");
        colors.add(color39);
        int[] rgb40 = {168, 164, 149};
        double[] lab40 = {67.31128450052123, -1.235143713646858, 8.290383742302488};
        Color color40 = new Color("#a8a495", rgb40, lab40, "grimsi");
        colors.add(color40);
        int[] rgb41 = {255, 254, 182};
        double[] lab41 = {98.24160812733408, -10.461719339679544, 34.64985561719007};
        Color color41 = new Color("#fffeb6", rgb41, lab41, "açık bej");
        colors.add(color41);
        int[] rgb42 = {73, 6, 72};
        double[] lab42 = {15.56365955832964, 37.61314641674795, -22.97549197612987};
        Color color42 = new Color("#490648", rgb42, lab42, "koyu mor");
        colors.add(color42);
        int[] rgb43 = {119, 0, 1};
        double[] lab43 = {23.419016010390116, 45.62329631060219, 34.87236239299393};
        Color color43 = new Color("#770001", rgb43, lab43, "koyu kan kırmızısı");
        colors.add(color43);
        int[] rgb44 = {200, 60, 185};
        double[] lab44 = {50.703417775059236, 68.08903464877386, -36.962116870930494};
        Color color44 = new Color("#c83cb9", rgb44, lab44, "pespembe");
        colors.add(color44);
        int[] rgb45 = {0, 4, 53};
        double[] lab45 = {3.106218293925778, 14.713471451588301, -30.028263808343407};
        Color color45 = new Color("#000435", rgb45, lab45, "koyu lacivert");
        colors.add(color45);
        int[] rgb46 = {228, 203, 255};
        double[] lab46 = {85.21317166006746, 18.261894124729228, -22.247846716943197};
        Color color46 = new Color("#e4cbff", rgb46, lab46, "soluk lila");
        colors.add(color46);
        int[] rgb47 = {42, 1, 52};
        double[] lab47 = {6.882082092977495, 29.126612280164473, -22.981963918526972};
        Color color47 = new Color("#2a0134", rgb47, lab47, "çok koyu mor");
        colors.add(color47);
        int[] rgb48 = {237, 200, 255};
        double[] lab48 = {85.26760238843525, 22.70763559530675, -22.09276747801885};
        Color color48 = new Color("#edc8ff", rgb48, lab48, "açık lila");
        colors.add(color48);
        int[] rgb49 = {254, 2, 162};
        double[] lab49 = {55.809263472702426, 87.02908433697282, -14.82233560729249};
        Color color49 = new Color("#fe02a2", rgb49, lab49, "çingene pembesi");
        colors.add(color49);
        int[] rgb50 = {154, 48, 1};
        double[] lab50 = {35.95755924639145, 42.52582893496631, 47.631084980533785};
        Color color50 = new Color("#9a3001", rgb50, lab50, "kestane");
        colors.add(color50);
        int[] rgb51 = {246, 206, 252};
        double[] lab51 = {87.37008455208135, 21.85217568609549, -17.252777671767827};
        Color color51 = new Color("#f6cefc", rgb51, lab51, "çok açık mor");
        colors.add(color51);
        int[] rgb52 = {0, 1, 51};
        double[] lab52 = {2.355125894475499, 14.771081427020855, -29.75165350896952};
        Color color52 = new Color("#000133", rgb52, lab52, "çok koyu mavi");
        colors.add(color52);
        int[] rgb53 = {198, 156, 4};
        double[] lab53 = {66.36028100549399, 4.059307580418503, 69.58678524055694};
        Color color53 = new Color("#c69c04", rgb53, lab53, "hardal sarısı");
        colors.add(color53);
        int[] rgb54 = {222, 157, 172};
        double[] lab54 = {71.2977236461722, 26.339347846669025, 1.9353325057077875};
        Color color54 = new Color("#de9dac", rgb54, lab54, "soluk pembe");
        colors.add(color54);
        int[] rgb55 = {165, 251, 213};
        double[] lab55 = {92.48553748483035, -33.92125948759844, 10.045900023362186};
        Color color55 = new Color("#a5fbd5", rgb55, lab55, "soluk turkuaz");
        colors.add(color55);
        int[] rgb56 = {152, 94, 43};
        double[] lab56 = {45.4352652552932, 19.030977008174133, 38.15203769265669};
        Color color56 = new Color("#985e2b", rgb56, lab56, "sepya");
        colors.add(color56);
        int[] rgb57 = {15, 254, 249};
        double[] lab57 = {90.69986487082805, -49.04969054278296, -11.641745506720014};
        Color color57 = new Color("#0ffef9", rgb57, lab57, "parlak turkuaz");
        colors.add(color57);
        int[] rgb58 = {181, 148, 16};
        double[] lab58 = {62.542209629720645, 0.9001633491342864, 64.20941487284173};
        Color color58 = new Color("#b59410", rgb58, lab58, "koyu altın rengi");
        colors.add(color58);
        int[] rgb59 = {102, 124, 62};
        double[] lab59 = {48.992392280175935, -18.898675050101676, 31.03865525159413};
        Color color59 = new Color("#667c3e", rgb59, lab59, "asker yeşili");
        colors.add(color59);
        int[] rgb60 = {254, 70, 165};
        double[] lab60 = {60.03999818345277, 75.47743888605146, -10.208401185379046};
        Color color60 = new Color("#fe46a5", rgb60, lab60, "parlak pembe");
        colors.add(color60);
        int[] rgb61 = {255, 91, 0};
        double[] lab61 = {60.55340492083914, 59.67169486024093, 70.416570760288};
        Color color61 = new Color("#ff5b00", rgb61, lab61, "parlak turuncu");
        colors.add(color61);
        int[] rgb62 = {253, 255, 82};
        double[] lab62 = {97.23240695266054, -20.371127951666956, 78.16186205621662};
        Color color62 = new Color("#fdff52", rgb62, lab62, "limon sarısı");
        colors.add(color62);
        int[] rgb63 = {60, 77, 3};
        double[] lab63 = {30.095897773354856, -17.35584207272295, 36.79238718363344};
        Color color63 = new Color("#3c4d03", rgb63, lab63, "koyu zeytin yeşili");
        colors.add(color63);
        int[] rgb64 = {206, 174, 250};
        double[] lab64 = {76.25061322776038, 26.088145704787237, -33.45683823312711};
        Color color64 = new Color("#ceaefa", rgb64, lab64, "soluk mor");
        colors.add(color64);
        int[] rgb65 = {160, 4, 152};
        double[] lab65 = {37.530883965814965, 67.68656289652685, -38.61996786399342};
        Color color65 = new Color("#a00498", rgb65, lab65, "parlak mor");
        colors.add(color65);
        int[] rgb66 = {156, 109, 165};
        double[] lab66 = {52.643679629141474, 28.574088806162578, -22.741573745451582};
        Color color66 = new Color("#9c6da5", rgb66, lab66, "koyu lila");
        colors.add(color66);
        int[] rgb67 = {255, 253, 1};
        double[] lab67 = {96.62077872115692, -20.59859212138837, 94.03459129184529};
        Color color67 = new Color("#fffd01", rgb67, lab67, "parlak sarı");
        colors.add(color67);
        int[] rgb68 = {164, 190, 92};
        double[] lab68 = {73.21476802996396, -23.94207948685345, 46.0675347132796};
        Color color68 = new Color("#a4be5c", rgb68, lab68, "açık zeytin yeşili");
        colors.add(color68);
        int[] rgb69 = {152, 0, 2};
        double[] lab69 = {31.066521961324042, 54.476886496661436, 44.06971922515648};
        Color color69 = new Color("#980002", rgb69, lab69, "kan kırmızısı");
        colors.add(color69);
        int[] rgb70 = {4, 92, 90};
        double[] lab70 = {34.839266508444254, -23.16443449323427, -5.483324600991468};
        Color color70 = new Color("#045c5a", rgb70, lab70, "koyu turkuaz");
        colors.add(color70);
        int[] rgb71 = {255, 255, 255};
        double[] lab71 = {100.0, 0.00526049995830391, -0.010408184525267927};
        Color color71 = new Color("#ffffff", rgb71, lab71, "beyaz");
        colors.add(color71);
        int[] rgb72 = {255, 254, 122};
        double[] lab72 = {97.44987068341821, -16.540111438264503, 62.29644114897337};
        Color color72 = new Color("#fffe7a", rgb72, lab72, "açık sarı");
        colors.add(color72);
        int[] rgb73 = {216, 220, 214};
        double[] lab73 = {87.30998724137378, -2.427023242596693, 2.4602135375640044};
        Color color73 = new Color("#d8dcd6", rgb73, lab73, "açık gri");
        colors.add(color73);
        int[] rgb74 = {237, 13, 217};
        double[] lab74 = {55.382185870969295, 89.3627934758977, -47.57493561864603};
        Color color74 = new Color("#ed0dd9", rgb74, lab74, "fuşya");
        colors.add(color74);
        int[] rgb75 = {4, 133, 209};
        double[] lab75 = {53.389186215992794, -1.9629748082834464, -47.37396637646793};
        Color color75 = new Color("#0485d1", rgb75, lab75, "masmavi");
        colors.add(color75);
        int[] rgb76 = {255, 207, 220};
        double[] lab76 = {87.51072947916336, 18.872333527307216, -0.022824583699398993};
        Color color76 = new Color("#ffcfdc", rgb76, lab76, "açık pembe");
        colors.add(color76);
        int[] rgb77 = {213, 182, 10};
        double[] lab77 = {74.58711892498046, -3.0189091839946114, 75.501079825245};
        Color color77 = new Color("#d5b60a", rgb77, lab77, "koyu sarı");
        colors.add(color77);
        int[] rgb78 = {54, 55, 55};
        double[] lab78 = {22.973178758542865, -0.4289450538136619, -0.15450529588209028};
        Color color78 = new Color("#363737", rgb78, lab78, "koyu gri");
        colors.add(color78);
        int[] rgb79 = {198, 81, 2};
        double[] lab79 = {49.368516290188, 43.81836776175297, 58.82842727268765};
        Color color79 = new Color("#c65102", rgb79, lab79, "koyu turuncu");
        colors.add(color79);
        int[] rgb80 = {253, 170, 72};
        double[] lab80 = {76.13058560954501, 22.182675184748536, 60.751846415298495};
        Color color80 = new Color("#fdaa48", rgb80, lab80, "açık turuncu");
        colors.add(color80);
        int[] rgb81 = {52, 28, 2};
        double[] lab81 = {13.015180304479824, 9.247341181049308, 18.686795628363317};
        Color color81 = new Color("#341c02", rgb81, lab81, "koyu kahverengi");
        colors.add(color81);
        int[] rgb82 = {255, 223, 0};
        double[] lab82 = {88.939189421875, -5.950300196582326, 88.5617283249729};
        Color color82 = new Color("#ffdf00", rgb82, lab82, "altın sarısı");
        colors.add(color82);
        int[] rgb83 = {203, 65, 107};
        double[] lab83 = {48.93167857399827, 57.39613738330951, 6.946883494822442};
        Color color83 = new Color("#cb416b", rgb83, lab83, "koyu pembe");
        colors.add(color83);
        int[] rgb84 = {0, 0, 0};
        double[] lab84 = {0.0, 0.0, 0.0};
        Color color84 = new Color("#000000", rgb84, lab84, "siyah");
        colors.add(color84);
        int[] rgb85 = {0, 17, 70};
        double[] lab85 = {7.615669190614323, 17.964598800752754, -34.915309778166495};
        Color color85 = new Color("#001146", rgb85, lab85, "lacivert");
        colors.add(color85);
        int[] rgb86 = {230, 218, 166};
        double[] lab86 = {86.85884762586572, -3.7750552143892557, 27.131577224815363};
        Color color86 = new Color("#e6daa6", rgb86, lab86, "bej rengi");
        colors.add(color86);
        int[] rgb87 = {0, 3, 91};
        double[] lab87 = {7.411176922788123, 35.283770275772746, -49.73462747566938};
        Color color87 = new Color("#00035b", rgb87, lab87, "koyu mavi");
        colors.add(color87);
        int[] rgb88 = {199, 159, 239};
        double[] lab88 = {71.67046095516393, 29.816550529453423, -34.62947977062629};
        Color color88 = new Color("#c79fef", rgb88, lab88, "lavanta");
        colors.add(color88);
        int[] rgb89 = {3, 53, 0};
        double[] lab89 = {18.212567147154886, -27.567725878495043, 25.305874840997877};
        Color color89 = new Color("#033500", rgb89, lab89, "koyu yeşil");
        colors.add(color89);
        int[] rgb90 = {191, 119, 246};
        double[] lab90 = {62.443287807215256, 50.76229788797709, -53.00507878449163};
        Color color90 = new Color("#bf77f6", rgb90, lab90, "açık mor");
        colors.add(color90);
        int[] rgb91 = {146, 149, 145};
        double[] lab91 = {61.35124132286106, -1.861103907138506, 1.7206410810920447};
        Color color91 = new Color("#929591", rgb91, lab91, "gri renk");
        colors.add(color91);
        int[] rgb92 = {255, 255, 20};
        double[] lab92 = {97.15877303287256, -21.389741529168006, 92.93335694897837};
        Color color92 = new Color("#ffff14", rgb92, lab92, "sarı");
        colors.add(color92);
        int[] rgb93 = {249, 115, 6};
        double[] lab93 = {63.6838745290198, 46.89721743292985, 70.65173850937713};
        Color color93 = new Color("#f97306", rgb93, lab93, "turuncu");
        colors.add(color93);
        int[] rgb94 = {149, 208, 255};
        double[] lab94 = {81.13816714013853, -7.154644240120467, -28.94589524971991};
        Color color94 = new Color("#95d0ff", rgb94, lab94, "açık mavi");
        colors.add(color94);
        int[] rgb95 = {255, 0, 0};
        double[] lab95 = {53.23288178584245, 80.10930952982204, 67.22006831026425};
        Color color95 = new Color("#ff0000", rgb95, lab95, "kırmızı");
        colors.add(color95);
        int[] rgb96 = {101, 55, 0};
        double[] lab96 = {28.11178375992548, 16.747091998164485, 38.3622810923717};
        Color color96 = new Color("#653700", rgb96, lab96, "kahverengi");
        colors.add(color96);
        int[] rgb97 = {255, 192, 203};
        double[] lab97 = {83.5847988577587, 24.149661012571265, 3.315387151150828};
        Color color97 = new Color("#ffc0cb", rgb97, lab97, "pembe");
        colors.add(color97);
        int[] rgb98 = {0, 255, 0};
        double[] lab98 = {87.73703347354422, -86.18463649762525, 83.18116474777854};
        Color color98 = new Color("#00ff00", rgb98, lab98, "yeşil");
        colors.add(color98);
        int[] rgb99 = {126, 30, 156};
        double[] lab99 = {33.48746352543491, 57.30830309217868, -47.865748471459376};
        Color color99 = new Color("#7e1e9c", rgb99, lab99, "mor");
        colors.add(color99);
    }

    // renkleri liste halinde döndür
    ArrayList<Color> getColors() {
        return colors;
    }

    // hexcode a göre rengin ismini döndür
    Color getNameFromHex(String hexcode) {
        for (Color color : colors) {
            if (color.getHexcode().equals(hexcode))
                return color;
        }
        return null;
    }

    /*
    // CIEDE2000 Color-Difference
    private double hp_f(double x, double y) {
        if (x == 0 && y == 0)
            return 0;
        else {
            double tmphp = Math.toDegrees(Math.atan2(x,y));
            if (tmphp >= 0)
                return tmphp;
            else
                return tmphp + 360;
        }
    }
    private double dhp_f(double C1, double C2, double h1p, double h2p) {
        if (C1 * C2 == 0)
            return 0;
        else if (Math.abs(h2p - h1p) <= 180)
            return h2p - h1p;
        else if ((h2p - h1p) > 180)
            return (h2p - h1p) - 360;
        else if ((h2p - h1p) < -180)
            return (h2p - h1p) + 360;
        else
            throw(new Error());
    }
    private double a_hp_f(double C1, double C2, double h1p, double h2p) {
        if (C1 * C2 == 0)
            return h1p+h2p;
        else if (Math.abs(h1p - h2p) <= 180)
            return (h1p + h2p) / 2.0;
        else if ((Math.abs(h1p - h2p) > 180) && ((h1p + h2p) < 360))
            return (h1p + h2p + 360) / 2.0;
        else if ((Math.abs(h1p - h2p) > 180) && ((h1p + h2p) >= 360))
            return (h1p + h2p - 360) / 2.0;
        else
            throw(new Error());
    }
    // 2 renk arasındaki uzaklığı hesapla
    // 1. formul = Uzaklık = karekök(xd*xd + yd*yd + zd*zd)
    private double calculateDist(double[] lab1, double[] lab2) {
        // Get L,a,b values for color 1
        double L1 = lab1[0];
        double a1 = lab1[1];
        double b1 = lab1[2];

        // Get L,a,b values for color 2
        double L2 = lab2[0];
        double a2 = lab2[1];
        double b2 = lab2[2];

        // Weight factors
        double kL = 1;
        double kC = 1;
        double kH = 1;

        // Step 1: Calculate C1p, C2p, h1p, h2p
        double C1 = Math.sqrt(Math.pow(a1, 2) + Math.pow(b1, 2)); //(2)
        double C2 = Math.sqrt(Math.pow(a2, 2) + Math.pow(b2, 2)); //(2)

        double a_C1_C2 = (C1+C2 )/ 2.0;             //(3)

        double G = 0.5 * (1 - Math.sqrt(Math.pow(a_C1_C2 , 7.0) /
                (Math.pow(a_C1_C2, 7.0) + Math.pow(25.0, 7.0)))); //(4)

        double a1p = (1.0 + G) * a1; //(5)
        double a2p = (1.0 + G) * a2; //(5)

        double C1p = Math.sqrt(Math.pow(a1p, 2) + Math.pow(b1, 2)); //(6)
        double C2p = Math.sqrt(Math.pow(a2p, 2) + Math.pow(b2, 2)); //(6)

        double h1p = hp_f(b1, a1p); //(7)
        double h2p = hp_f(b2, a2p); //(7)

        // Step 2: Calculate dLp, dCp, dHp
        double dLp = L2 - L1; //(8)
        double dCp = C2p - C1p; //(9)

        double dhp = dhp_f(C1, C2, h1p, h2p); //(10)
        double dHp = 2 * Math.sqrt(C1p * C2p) * Math.sin(Math.toRadians(dhp / 2.0)); //(11)

        // Step 3: Calculate CIEDE2000 Color-Difference
        double a_L = (L1 + L2) / 2.0; //(12)
        double a_Cp = (C1p + C2p) / 2.0; //(13)

        double a_hp = a_hp_f(C1, C2, h1p, h2p); //(14)
        double T = 1 - 0.17 * Math.cos(Math.toRadians(a_hp - 30)) + 0.24 * Math.cos(Math.toRadians(2 * a_hp)) +
                0.32 * Math.cos(Math.toRadians(3 * a_hp + 6)) - 0.20 * Math.cos(Math.toRadians(4 * a_hp - 63)); //(15)
        double d_ro = 30 * Math.exp(-(Math.pow((a_hp - 275) / 25,2))); //(16)
        double RC = Math.sqrt((Math.pow(a_Cp, 7.0)) / (Math.pow(a_Cp, 7.0) + Math.pow(25.0, 7.0)));//(17)
        double SL = 1 + ((0.015 * Math.pow(a_L - 50, 2)) /
                Math.sqrt(20 + Math.pow(a_L - 50, 2.0)));//(18)
        double SC = 1 + 0.045 * a_Cp;//(19)
        double SH = 1 + 0.015 * a_Cp * T;//(20)
        double RT = -2 * RC * Math.sin(Math.toRadians(2 * d_ro));//(21)
        double dE = Math.sqrt(Math.pow(dLp /(SL * kL), 2) + Math.pow(dCp /(SC * kC), 2) +
                Math.pow(dHp /(SH * kH), 2) + RT * (dCp /(SC * kC)) * (dHp / (SH * kH))); //(22)
        return dE;
    }
    */
}
