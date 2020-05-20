package app;

public class test {
    public static void main(String[] args) {

        ImmutableLinkedList ImList = new ImmutableLinkedList();

        ImList.add(1);
        ImList.add(2);
        ImList.add(3);
        ImList.add(4);

        System.out.println(ImList.count());
        //ImList.show_my_im_list(ImList);

        System.out.println(ImList.add(1).value);
        System.out.println(ImList.add(2).value);
        System.out.println(ImList.add(3).value);
        System.out.println(ImList.add(4).value);
        System.out.println(ImList.find(3));
        System.out.println(ImList.find(4));

        ImList.remove(ImList.find(2));
        System.out.println("Delete successfully!");

        System.out.println(ImList.count());

        ImList.insert(ImList.find(4),2);
        System.out.println("Insert successfully!");

        System.out.println(ImList.count());

    }
}
