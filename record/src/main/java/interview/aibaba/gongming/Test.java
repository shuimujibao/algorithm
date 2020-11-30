package interview.aibaba.gongming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunxiaoyu3
 * @description 分组问题
 * 每组组员星座 与部门均不得重复
 * @createTime 2020/11/30 10:24:00
 */
@SuppressWarnings("unchecked")
public class Test {

    public static void main(String[] args) {
        User user1 = User.builder().id(1).constellation(2).department(3).build();
        User user2 = User.builder().id(2).constellation(2).department(18).build();
        User user3 = User.builder().id(3).constellation(5).department(23).build();
        User user4 = User.builder().id(4).constellation(1).department(33).build();
        User user5 = User.builder().id(5).constellation(3).department(18).build();
        User user6 = User.builder().id(6).constellation(4).department(67).build();
        List<User> userList = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

        int n = 3;
        //6个人按指定规则分为三组
        List<GroupInformation> groupInformationList = GroupStrategy(n, userList);
        System.out.println("当前用户数据所分布的星座排列组合信息：" + constellationCombinations);
        System.out.println("分组后所有小组信息" + groupInformationList);
    }

    //当前数组所有星座的排列组合
    private static List<List<Integer>> constellationCombinations = new ArrayList<>();

    //构建桶将相同星座的人置于同一个桶中
    private static List<User>[] bucket = new ArrayList[12];


    /**
     * @param numberEachGroup 每组成员数量
     * @param userList        所有用户列表信息
     * @return List<GroupInformation> 所有小组信息
     */
    private static List<GroupInformation> GroupStrategy(int numberEachGroup, List<User> userList) {
        //分组结果信息
        List<GroupInformation> result = new ArrayList<>();

        for (User user : userList) {
            //当前用户星座信息
            int constellation = user.getConstellation();

            if (bucket[constellation] == null) {
                bucket[constellation] = new ArrayList<>();
            }
            bucket[constellation].add(user);
        }

        //运行至此处时，同一下标中的集合 则为相同星座的用户
        List<Integer> constellation = new ArrayList<>();

        for (int i = 0; i < bucket.length; i++) {
            //过滤掉不存在的星座
            List<User> users = bucket[i];
            if (users != null) {
                constellation.add(i);
            }
        }
        Integer[] constellationArray = constellation.toArray(new Integer[0]);
        //列出所有星座的排列组合 C（12，NumberEachGroup）
        find(constellationArray, numberEachGroup, 0, 0);

        //获取到当前用户所处星座的所有排列，下一步考虑部门不能重复
        List<User> users = new ArrayList<>();
        for (List<Integer> constellationCombination : constellationCombinations) {
            for (int i = 0; i < constellationCombination.size(); i++) {
                List<User> usersTemp = bucket[constellationCombination.get(i)];
                if (i == 0) {
                    users = usersTemp;
                }
                users = users.size() < usersTemp.size() ? users : usersTemp;
            }
            //获取到一组用户信息
            GroupInformation groupInformation = new GroupInformation();
            groupInformation.setUserList(users);
            result.add(groupInformation);
        }
        return result;
    }

    public static Stack<Integer> stack = new Stack<>();


    /**
     * @param bucket          元素
     * @param numberEachGroup 要选多少个元素
     * @param has             当前有多少个元素
     * @param cur             当前选到的下标
     */
    private static void find(Integer[] bucket, int numberEachGroup, int has, int cur) {
        if (has == numberEachGroup) {
            constellationCombinations.add((List<Integer>) stack.clone());
            return;
        }

        for (int i = cur; i < bucket.length; i++) {
            if (!stack.contains(bucket[i])) {
                stack.add(bucket[i]);
                find(bucket, numberEachGroup, has + 1, i);
                stack.pop();
            }
        }
    }
}
