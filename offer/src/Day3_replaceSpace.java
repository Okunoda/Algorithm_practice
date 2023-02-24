/**
 * @author Okunoda
 * @date 2023年02月24日16:20
 */
class Day3_replaceSpace {
    public String replaceSpace(String s) {
        //法一：偷鸡
//        return s.replace(" ","%20");

        //法二：按每个字符来

        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char ch : chars){
            if(ch==' ')
                result.append("%20");
            result.append(ch);
        }
        return result.toString();
    }
}