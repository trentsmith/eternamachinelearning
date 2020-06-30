import java.util.ArrayList;
//import java.util.String;

class Main 
{
    public static void main(String []args)
    {
        NeuralNetwork nn = new NeuralNetwork();
        Node head = new Node("test","(");
                nn.head= nn.push(nn.head,"test2",".");
        nn.head.dot= nn.push(nn.head.dot,"test3",".");
        nn.printList();
        nn.findAnswer(nn.head) ;
        System.out.println("Hello World");

        System.out.println(nn.arrlist);
        
    }
}
class Node
{


    public String ans;
    public String puzzle;
    public Node dot;
    public Node line1;
    public Node line2;
    Node(String ans,String puzzle)
    {
        this.ans = ans;
        this.puzzle = puzzle;
        dot = null;
        line1 = null;
        line2 = null;
    }
}

class NeuralNetwork
{
    public Node head; 
    ArrayList<String> arrlist = new ArrayList<String>();
    String puzzle;
    String answer;
    /* Linked list Node*/

    // An utility function to merge two sorted linked lists
/* Utility function to insert a node at begining of the
linked list */
    public Node push(Node head_ref, String ans,String puzzle)
    {
/* 1 & 2: Allocate the Node &
Put in the data*/
        Node new_node = new Node(ans,puzzle);

        /* 3. Make next of new Node as head */
        if(puzzle.substring(puzzle.length() - 1)==".")
        {
            new_node.dot = head_ref;
        }
        if(puzzle.substring(puzzle.length() - 1).equals(")"))
        {
            new_node.line1 = head_ref;
        }
        if(puzzle.substring(puzzle.length() - 1).equals("("))
        {
            new_node.line2 = head_ref;
        }
        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return Rto link it back */
        return head_ref;
    }

    public void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.ans);
            if(temp.dot!=null)
            {
                temp = temp.dot;
            }
            else if(temp.line1!=null)
            {
                temp = temp.line1;
            }
            else if(temp.line2!=null)
            {
                temp = temp.line1;
            }
            else
            {
                temp = null;
            }
        }
        System.out.println();
    }

    public String findAnswer(Node head)
    {
        Node temp = head;
        String ans="";
        int count= 0;
        for(i=0;i<puzzle.lenghth();i++)
        {
            if(temp.line1!=null)
            {
                temp = temp.line1;
                ans = temp.line1.ans;
                count++;
            }
            else if(temp.line2!=null)
            {
                temp = temp.line2;
                ans = temp.line2.ans;
                count--;
                if(count == 0)
                {
                  arrlist.add(ans);
                  this.answer = ans;
                  temp = head;
                }
            }
            else if(temp.dot!=null)
            {
                temp = temp.dot;
                ans = temp.ans;
                continue;
            }
            else
            {
                temp = null;
            }
        }
        return ans;
    }
}