import java.io.*;
import java.util.*;
public class Main {

    // grid: 그리드 / N, M: 그리드의 크기
    static char[][] grid;
    static int N, M;
    // cmd: 주인공이 이동하는 방향 정보
    static int[] cmd;
    // dx, dy: 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // sx, sy: 주인공의 시작 위치(고정)
    // cx, cy: 주인공의 현재 위치
    static int sx, sy, cx, cy;
    // 주인공 정보
    static class User {
        int hp;         // 주인공의 현재 체력
        int mhp;        // 주인공의 최대 체력
        int att;        // 주인공의 공격력
        int def;        // 주인공의 방어력
        int lv;         // 주인공의 레벨
        int exp;        // 주인공의 현재 경험치
        int mexp;       // 주인공의 최대 경험치
        int w;          // 무기로 인해 얻는 공격력
        int a;          // 방어구로 인해 얻는 방어력
        HashSet<String> o; // 주인공이 착용하고 있는 장신구들 (최대 4개)
        User(int hp, int mhp, int att, int def, int lv, int exp, int mexp, int w, int a, HashSet<String> o) {
            this.hp = hp;
            this.mhp = mhp;
            this.att = att;
            this.def = def;
            this.lv = lv;
            this.exp = exp;
            this.mexp = mexp;
            this.w = w;
            this.a = a;
            this.o = o;
        }
    }
    // 주인공 그 자체.
    static User user;
    // 총 몬스터 개수
    static int mCnt;
    // 몬스터 정보
    static class Monster {
        String S;   // 몬스터의 이름
        int W;      // 몬스터의 공격력
        int A;      // 몬스터의 방어력
        int H;      // 몬스터의 최대 체력
        int E;      // 몬스터를 쓰러뜨렸을 때 얻는 경험치
        boolean B;  // 보스 여부
        Monster(String S, int W, int A, int H, int E, boolean B) {
            this.S = S;
            this.W = W;
            this.A = A;
            this.H = H;
            this.E = E;
            this.B = B;
        }
    }
    // 몬스터 정보가 담겨있는 배열
    static Monster[][] mArr;
    // 총 아이템 개수
    static int iCnt;
    // 아이템 정보
    static class Item {
        String T;   // 장신구 타입
        String S;   // W, A일 때는 숫자, O인 경우 HR, RE, CO, EX, DX, HU, CU 중 하나
        Item(String T, String S) {
            this.T = T;
            this.S = S;
        }
    }
    // 장신구 정보가 담겨 있는 배열
    static Item[][] iArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        mArr = new Monster[N][M];
        iArr = new Item[N][M];
        mCnt = 0;
        iCnt = 0;
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '&' || grid[i][j] == 'M') {
                    mCnt++;
                } else if (grid[i][j] == 'B') {
                    iCnt++;
                } else if (grid[i][j] == '@') {
                    sx = i;
                    sy = j;
                    cx = i;
                    cy = j;
                }
            }
        }
        String str = br.readLine();
        cmd = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'U') {
                cmd[i] = 0;
            } else if (str.charAt(i) == 'D') {
                cmd[i] = 1;
            } else if (str.charAt(i) == 'L') {
                cmd[i] = 2;
            } else {
                cmd[i] = 3;
            }
        }
        for (int i = 0; i < mCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String s = st.nextToken();
            int w = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean b = grid[x][y] == 'M';
            mArr[x][y] = new Monster(s, w, a, h, e, b);
        }
        for (int i = 0; i < iCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String t = st.nextToken();
            String s = st.nextToken();
            iArr[x][y] = new Item(t, s);
        }
        user = new User(20, 20, 2, 2, 1, 0, 5, 0, 0, new HashSet<>());
        for (int i = 0; i < cmd.length; i++) {
            // 1. 주인공을 이동시킬 새 위치를 구한다.
            int nx = cx + dx[cmd[i]];
            int ny = cy + dy[cmd[i]];
            // 2. 만약 움직일 수 없는 명령이라면 이동하지 않는다.
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || grid[nx][ny] == '#') {
                // 움직일 수 없을 때 현재 위치가 가시 함정이라면...
                if (grid[cx][cy] == '^') {
                    if (user.o.contains("DX")) {
                        user.hp -= 1;
                    } else {
                        user.hp -= 5;
                    }
                }
                // 가시 함정에 의해 죽으면 YOU HAVE BEEN KILLED BY SPIKE TRAP..을 출력하고 종료
                if (user.hp <= 0) {
                    user.hp = 0;
                    // RE를 들고 있다면...
                    if (user.o.contains("RE")) {
                        user.o.remove("RE");
                        user.hp = user.mhp;
                        cx = sx;
                        cy = sy;
                        grid[cx][cy] = '@';
                        continue;
                    }
                    printResult(2, i + 1, "SPIKE TRAP");
                    System.exit(0);
                }
            }
            // 3. 빈 칸을 만났다면 주인공의 위치를 빈 칸으로 옮긴다.
            else if (grid[nx][ny] == '.') {
                if (grid[cx][cy] != '^') {
                    grid[cx][cy] = '.';
                }
                grid[nx][ny] = '@';
                cx = nx;
                cy = ny;
            }
            // 4. 가시 함정을 만났다면 주인공의 체력을 5 깎는다.
            // 그전에 장신구를 확인해서 Dexterity(DX)가 존재하면 1만 깎는다.
            else if (grid[nx][ny] == '^') {
                if (user.o.contains("DX")) {
                    user.hp -= 1;
                } else {
                    user.hp -= 5;
                }
                // 가시 함정이 사라지지 않음에 주의하자.
                if (grid[cx][cy] != '^') {
                    grid[cx][cy] = '.';
                }
                cx = nx;
                cy = ny;
                // 가시 함정에 의해 죽으면 YOU HAVE BEEN KILLED BY SPIKE TRAP..을 출력하고 종료
                if (user.hp <= 0) {
                    user.hp = 0;
                    // RE를 들고 있다면...
                    if (user.o.contains("RE")) {
                        user.o.remove("RE");
                        user.hp = user.mhp;
                        cx = sx;
                        cy = sy;
                        grid[cx][cy] = '@';
                        continue;
                    }
                    printResult(2, i + 1, "SPIKE TRAP");
                    System.exit(0);
                }
            }
            // 5. 아이템을 얻었다면
            else if (grid[nx][ny] == 'B') {
                // 우선 위치부터 이동시키자. (아이템은 열리면 빈 칸이 된다)
                if (grid[cx][cy] != '^') {
                    grid[cx][cy] = '.';
                }
                grid[nx][ny] = '.';
                cx = nx;
                cy = ny;
                // 5.1 만약 무기(W)를 획득했다면
                if (iArr[nx][ny].T.equals("W")) {
                    // 새로운 무기로 교체한다
                    user.w = Integer.parseInt(iArr[nx][ny].S);
                }
                // 5.2 만약 방어구(D)를 획득했다면
                else if (iArr[nx][ny].T.equals("A")) {
                    // 새로운 방어구로 교체한다
                    user.a = Integer.parseInt(iArr[nx][ny].S);
                }
                // 만약 장신구(O)를 획득했다면
                else {
                    // 장신구의 개수가 4개가 넘어가면 착용 불가
                    if (user.o.size() == 4) {
                        continue;
                    }
                    // 해당 장신구 타입이 이미 존재하면 착용 불가
                    if (user.o.contains(iArr[nx][ny].S)) {
                        continue;
                    }
                    user.o.add(iArr[nx][ny].S);
                }
            }
            // 6. 몬스터를 만났다면
            else {
                if (grid[cx][cy] != '^') {
                    grid[cx][cy] = '.';
                }
                cx = nx;
                cy = ny;
                Monster monster = mArr[nx][ny];
                // 몬스터의 초기 체력
                int SH = monster.H;
                // 주인공이 먼저 선공을 한다.
                // 공격을 할때는 공격력+무기공격력을 더한다.
                // CO가 있으면 (공격력+무기공격력)은 2배가 된다.
                // CO와 DX가 같이 있으면 (공격력+무기공격력)은 3배가 된다.
                // 보스 몬스터일 때, HU가 있으면 체력 최대 회복
                if (monster.B && user.o.contains("HU")) {
                    user.hp = user.mhp;
                }
                // 공격 라운드 (0이 첫번째, 주인공의 공격/수비가 모두 끝나면 1 증가)
                int round = 0;
                while (true) {
                    /**
                     * 주인공 차례
                     */
                    int curAtt = user.att + user.w;
                    if (round == 0 && user.o.contains("CO")) {
                        if (user.o.contains("DX")) {
                            curAtt *= 3;
                        } else {
                            curAtt *= 2;
                        }
                    }
                    monster.H -= Math.max(1, curAtt - monster.A);
                    // 몬스터가 죽은 경우
                    if (monster.H <= 0) {
                        grid[nx][ny] = '@';
                        int curExp = monster.E;
                        // 경험치를 획득한다.
                        // HR이 있으면 체력을 3 회복한다.
                        // EX가 있으면 얻는 경험치가 1.2배가 된다.
                        if (user.o.contains("EX")) {
                            curExp = (int) (curExp * 1.2);
                        }
                        if (user.o.contains("HR")) {
                            user.hp = Math.min(user.hp + 3, user.mhp);
                        }
                        user.exp += curExp;
                        // 레벨업!
                        if (user.exp >= user.mexp) {
                            user.lv += 1;
                            user.mexp += 5;
                            user.mhp += 5;
                            user.att += 2;
                            user.def += 2;
                            user.hp = user.mhp;
                            user.exp = 0;
                        }
                        // 몬스터가 보스 몬스터라면...
                        if (monster.B) {
                            printResult(1, i + 1, "");
                            System.exit(0);
                        }
                        break;
                    }
                    /**
                     * 몬스터 차례
                     */
                    // 첫 번째 공격이면서 보스를 만났다면
                    if (round == 0 && monster.B && user.o.contains("HU")) {
                    } else {
                        user.hp -= Math.max(1, monster.W - (user.def + user.a));

                    }
                    // 만약 죽었다면...
                    if (user.hp <= 0) {
                        user.hp = 0;
                        // RE를 들고 있다면...
                        if (user.o.contains("RE")) {
                            user.o.remove("RE");
                            user.hp = user.mhp;
                            monster.H = SH;
                            cx = sx;
                            cy = sy;
                            grid[cx][cy] = '@';
                            break;
                        }
                        printResult(2, i + 1, monster.S);
                        System.exit(0);
                    }
                    round++;
                }
            }
        }
        printResult(0, cmd.length, "");
    }
    static void printResult(int type, int turn, String killedBy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (user.hp > 0 && i == cx && j == cy) {
                    System.out.print('@');
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Passed Turns : " + turn);
        System.out.println("LV : " + user.lv);
        System.out.println("HP : " + user.hp + "/" + user.mhp);
        System.out.println("ATT : " + user.att + "+" + user.w);
        System.out.println("DEF : " + user.def + "+" + user.a);
        System.out.println("EXP : " + user.exp + "/" + user.mexp);
        // 0: 입력이 끝났을 경우
        if (type == 0) {
            System.out.print("Press any key to continue.");
        }
        // 1: 보스 몬스터를 처치했을 경우
        else if (type == 1) {
            System.out.print("YOU WIN!");
        }
        // 2: 죽었을 경우
        else {
            System.out.print("YOU HAVE BEEN KILLED BY " + killedBy + "..");
        }
    }
}
