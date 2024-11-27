package examples.interviewquestions.strings.medium;

import java.util.Arrays;

public class MinCostToConvertStringOne {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        long[][] minCost = new long[26][26];
        long INF = Long.MAX_VALUE / 2;

        for (int i = 0; i < 26; i++) {
            Arrays.fill(minCost[i], INF);
            minCost[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], (long) cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (minCost[i][k] < INF && minCost[k][j] < INF) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (minCost[from][to] == INF) {
                return -1;
            }
            totalCost += minCost[from][to];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        MinCostToConvertStringOne solution = new MinCostToConvertStringOne();

        String source = "dohuoasrbheqcldovanrmvuflqaooipblgerrcspdgkanfgajfcvnraggkhvempkmknmvbhlgijjlmbvnkarrugnvqosalskudhrojtmruutqpaoqifvaechkdrdmlkvpqttqjvfoqlgujcflsbijsqeudflvafiofjplomnvelhmspofvnkgdkmjeskfemucsuckhtfhefeiadpvmhjtilcmregglvkusvpgbkgkadrdvsrhetckanocttdkllodnudsmfcipdkbelsddfsrbgbsqplubtiusdaoovecuhmuharqeotlaobfrpqjojkarrkkabqigkcueksdhvgoladigpedtnbcvsdoldfaqufiigavedfooosgjdrfqjstcumpophrqvabnltduurcbvpcmtgcsnbdnusahsdaoqfslqtrbbndqrchnpmvqlcjcpbqpptmgckbtseepfatqosaviofnkolmhgvprjnsknumpvcnnehhhlakehmsufouaqkhodnepddfhodtnbrsjqadpisvsikprjdhuffmrlvsqbihianmgfftetvidfcpssuhksqsajpljlelbfunbmdokstls";
        String target = "ftmktodtuhhgoinupclofpodgqoeilbnsbfdlccirkamirhvuiitetelitcjlitpealnafdbfiuiuhdcvreruarnavvnpuoleqsladdqdqqghmuljfrpucseopdhupmnmvragbtbkhcertsamqugmbmeqjtuhecpvphafogcdalnlekscfsopgobjqkoigkakspbudnbaaghflariclgilmmsrktrnnvfjbcdiamdcnuarsstienrodtvjehemtvbaepqcubvvftukccpatoepfcqcvcjmarfqsukngcemsronttdoqosfdrachpilmelsfsabtodkrnkabimaeiqidfpasuafkjgaujlcsmkmppcbhkunqigcuualgndmvctthlbguphtltikiquesqnupnunbucfhahgeacsohkvqltmhlbjsusivuftpajgmleieogllelrhkgcgmhdhlgoastmodhjehbhookdmhkardodomogeuaetajpqfchiptpfsqinbmactrajhkiaterfmbfaoiqartdqgrrkauaeippdlfjshuhggvqqdktkgmfjrnobvuinctpbudpuhrtllquuiodk";
        char[] original = {'k','p','c','a','g','u','f','m','l','g','c','a','b','a','e','r','d','e','c','u','c','s','i','d','r','t','u','c','h','n','c','n','g','q','s','e','n','g','t','v','t','p','a','b','i','m','q','l','a','v','e','e','l','c','c','q','g','h','r','t','q','k','r','v','b','c','u','c','r','h','k','h','b','j','l','s','n','s','u','g','b','q','h','t','a','g','m','j','h','h','o','f','l','v','b','g','f','j','h','d','t','a','f','t','j','r','e','k','r','m','v','q','h','p','n','n','v','v','s','p','o','a','v','v','h','v','b','m','a','g','k','f','a','o','i','b','c','l','r','j','b','g','i','v','c','u','q','a','j','j','p','i'};
        char[] changed = {'l','m','b','b','p','s','t','t','g','c','g','c','o','k','t','o','k','h','t','t','s','c','g','a','o','m','a','g','k','a','t','l','s','i','h','c','g','i','s','s','c','m','i','q','c','i','n','r','o','l','i','n','b','h','q','k','q','r','t','l','h','q','a','n','j','f','c','o','k','p','c','c','h','f','h','t','v','k','k','m','d','l','n','b','h','h','d','h','m','b','b','m','r','o','k','m','u','f','m','k','r','n','d','s','n','c','g','p','v','r','d','p','p','k','g','v','j','j','h','u','e','e','r','l','q','n','c','g','e','n','o','l','u','i','j','k','p','o','l','h','t','t','j','m','a','r','p','r','r','p','k','r'};
        int[] cost = {219285,799382,258246,827465,669141,174351,261267,209113,509734,285654,488334,593429,20793,304511,119499,643857,784110,542863,920621,198153,433239,31008,282449,183700,750458,346809,409595,506490,72340,808127,427748,488366,998361,526891,736603,302366,354401,362772,421133,893575,42333,454633,838982,723590,487245,471679,932646,736585,771116,15425,88294,548378,887612,610428,473340,992757,250093,719076,909692,790792,257079,872140,291958,782916,424011,323377,404034,238766,333154,687738,300844,842430,618929,91576,432140,12958,40423,11311,907905,929042,286818,416342,745574,908279,652579,167509,350579,45814,58};

        long result = solution.minimumCost(source, target, original, changed, cost);
        System.out.println("Total Minimum Cost: " + result);
    }
}
