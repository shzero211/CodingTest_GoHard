package barkingDog.연결리스트;

public class 연결리스트_구현 {
    static class ListNode{
        private String data;
        private ListNode nextNode;
        public ListNode(){
            this.data=null;
            this.nextNode=null;
        }
        public ListNode(String data){
            this.data=data;
            this.nextNode=null;
        }

        public ListNode(String data,ListNode nextNode){
            this.data=data;
            this.nextNode=nextNode;
        }

        public String getData(){
            return data;
        }
        public void setData(String data){
            this.data=data;
        }
    }
   private static  class LinkedList{
        private ListNode head;
        public LinkedList(){
            head=null;
        }

        //중간에 노드추가
        public void insertNode(ListNode preNode,String data){
            ListNode newNode=new ListNode(data);
            newNode.nextNode=preNode.nextNode;
            preNode.nextNode=newNode;
        }

        //처음이나 마지막에 삽입
        public void insertNode(String data){
            ListNode newNode=new ListNode(data);
            if(head==null){
                head=newNode;
            }else{
                ListNode tempNode=head;
                while(tempNode.nextNode!=null){
                    tempNode=tempNode.nextNode;
                }
                tempNode.nextNode=newNode;
            }
        }

        //중간에 있는 노드 삭제
        public void deleteNode(String data){
            //이전노드 기록
            ListNode preNode=head;
            //찾고자하는 삭제 데이터 기록
            ListNode tempNode=head.nextNode;
            //맨앞에 있는 노드라면
            if(data.equals(preNode.getData())){
                head=preNode.nextNode;
                preNode.nextNode=null;
            }else{
                //계속 타고타고 찾기
                while(tempNode!=null){
                    //찾았다면
                    if(data.equals(tempNode.getData())){
                        //찾았는데 마지막 노드이면
                        if(tempNode.nextNode==null){
                            preNode.nextNode=null;
                        }else{
                            //찾았고 마지막 노드가 아니면
                            preNode.nextNode=tempNode.nextNode;
                            tempNode.nextNode=null;
                        }
                        break;
                    }else{
                        //못찾았으면 계속 이동
                        preNode=tempNode;
                        tempNode=tempNode.nextNode;
                    }
                }
            }
        }

        public void deleteNode(){
            ListNode preNode;
            ListNode tempNode;
            if(head==null){
                return;
            }
            if(head.nextNode==null){
                head=null;
            }else{
                preNode=head;
                tempNode=head.nextNode;
                while(tempNode.nextNode!=null){
                    preNode=tempNode;
                    tempNode=tempNode.nextNode;
                }
                preNode.nextNode=null;
            }

        }

        public ListNode searchNode(String data){
            ListNode tempNode=head;
            while(tempNode!=null){
                if(data.equals(tempNode.getData())){
                    return tempNode;
                }else{
                    tempNode=tempNode.nextNode;
                }
            }
            return tempNode;
        }

        public void printList(){
            ListNode tempNode=head;
            while(tempNode!=null){
                System.out.print(tempNode.getData()+" ");
                tempNode=tempNode.nextNode;
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();

        linkedList.insertNode("one");
        linkedList.insertNode("two");
        linkedList.printList();

        linkedList.insertNode("three");
        linkedList.printList();

        linkedList.insertNode(linkedList.searchNode("two"),"ttwo");
        linkedList.printList();

        linkedList.deleteNode();
        linkedList.printList();

        linkedList.deleteNode("ttwo");
        linkedList.printList();


    }
}
