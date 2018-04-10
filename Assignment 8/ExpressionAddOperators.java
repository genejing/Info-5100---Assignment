class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        addOperatorsHelper(res, num, "",target,0,0,0);
        return res;
    }
    public void addOperatorsHelper(List<String> res,String num, String path,int target, int index,long tempValue,long prev) {
        if (index == num.length() && tempValue == target) {
                res.add(path);
                return;
        }
        for (int i = index;i < num.length();i++) {
            if (i != index && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index,i+1));
            if (index == 0) {
                addOperatorsHelper(res, num, path + curr, target, i + 1, curr, curr);
            } else {
                addOperatorsHelper(res, num, path + "+" + curr, target, i + 1, tempValue + curr, curr);
                addOperatorsHelper(res, num, path + "-" + curr, target, i + 1, tempValue - curr, -curr);
                addOperatorsHelper(res, num, path + "*" + curr, target, i + 1, tempValue - prev + prev * curr, prev * curr);
            }
        }
    }
}
