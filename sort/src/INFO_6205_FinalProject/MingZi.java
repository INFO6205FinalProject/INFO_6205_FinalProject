package INFO_6205_FinalProject;

public class MingZi {
    private String PinYin;
    private String HanZi;
    private int longest;
    public MingZi(String HanZi, int longest) {
        this.HanZi = HanZi;
        this.longest = longest;
    }
    private void toPinYin(){
        CharacterPinYinConvert convert = new CharacterPinYinConvert();
        String name = this.getHanZi();
        PinYin = convert.toPinYin(name);
        while(PinYin.length() < longest){
            PinYin = PinYin + "0";
        }
    }

    public String getHanZi() {
        return HanZi;
    }
    public String getPinYin(){
        return PinYin;
    }

    public static void main(String[] args) {
        MingZi name = new MingZi("王二丫", 20);
        name.toPinYin();
        System.out.println(name.getPinYin());
    }
}



