package DailyProblem;

/**
 * 11.6每日一题
 * 设计Goal解释器
 */
public class LC_1678 {

    // return command.replace("()","o").replace("(al)","al");
    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<command.length();i++){
            char temp = command.charAt(i);
            if(temp=='G') sb.append("G");
            else if(temp=='('){
                /**
                 *  一切在执行i+1操作之前 需判断i+1是否小于length 否则会越界
                 *  这一题是因为command.charAt(length-1)不可能是'(' 因为()是成对出现的
                 */
                if(i+1<command.length() && command.charAt(i+1)==')'){
                    sb.append("o");
                    /**
                     *  可加可不加 因为这边if只有两个判断 G (
                     *  所以其他也直接continue执行i++了
                     */
                    i++;
                }else {
                    sb.append("al");
                    i = i + 3;
                }
            }
        }

        return sb.toString();

    }
}
