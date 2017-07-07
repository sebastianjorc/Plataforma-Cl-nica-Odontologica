
/*
 * Java program to implement SkipList 
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.ConexionSQL;
 
/* Class SkipNode */
class SkipNode        
{
    int element;
    SkipNode right;
    SkipNode down;
 
    /* Constructor */
    public SkipNode(int x)
    {
        this(x, null, null);
    }
    /* Constructor */
    public SkipNode(int x, SkipNode rt, SkipNode dt)
    {
        element = x;
        right = rt;
        down = dt;
    }
}
 
/* Class SkipList */
class SkipList
{
    private SkipNode header;
    private int infinity;
    private SkipNode bottom = null;
    private SkipNode tail = null;
 
    /* Constructor */
    public SkipList(int inf)
    {
        infinity = inf;
        bottom = new SkipNode(0);
        bottom.right = bottom.down = bottom;
        tail = new SkipNode(infinity);
        tail.right = tail;
        header = new SkipNode(infinity, tail, bottom);
    }
    /* Function to insert element */
    public void insert(int x)
    {
        SkipNode current = header;
        bottom.element = x;
        while (current != bottom)
        {
            while (current.element < x)
            current = current.right;
            if (current.down.right.right.element < current.element){
                current.right = new SkipNode(current.element, current.right, current.down.right.right);
                current.element = current.down.right.element;
            }
            else	current = current.down;
        }
        if (header.right != tail)
            header = new SkipNode(infinity, tail, header);
    }
    public void makeEmpty()
    {
        header.right = tail;
        header.down = bottom;
    }
    public boolean isEmpty()
    {
        return header.right == tail && header.down == bottom;
    }
    private int elementAt(SkipNode t)
    {
        return t == bottom ? 0 : t.element;
    }
    public void printList()
    {
        System.out.print("\nSkiplist = ");
        SkipNode current = header;
        while( current.down != bottom )
            current = current.down;
        while (current.right != tail )
        {
            System.out.print(current.element +" ");
            current = current.right;
        }
        System.out.println();
    }
	public boolean search (int pk) {		
		SkipNode current = header;
        while (current != bottom)
        {
            while (current.element < pk)
	            current = current.right;
	            if (current.element==pk)
					return true;
	            else if (current.down.right.right.element < current.element)
	                current = current.down.right;
	            else	current = current.down;
        }
		return false;		
	}   
}
 
/* Class SkipListTest */
public class SkipListTest    
{    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        /* Creating object of SkipList */
        SkipList sl = new SkipList(100000000); 
        consulta(sl);
        System.out.println("SkipList List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSkipList List Operations\n");
            System.out.println("1. insert");
            System.out.println("2. check empty");
            System.out.println("3. clear");
            System.out.println("4. search");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                sl.insert( scan.nextInt() );   
                break;                          
            case 2 : 
                System.out.println("Empty status = "+ sl.isEmpty());
                break;            
            case 3 : 
                System.out.println("List cleared\n");
                sl.makeEmpty();
                break;            
            case 4 : 
                System.out.println("List search\n");
                System.out.println("Resultado: "+sl.search(scan.nextInt()));
                break;                    
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
            /*  Display List  */ 
            sl.printList();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);    
 
        } while (ch == 'Y'|| ch == 'y');               
    }


	private static void consulta(SkipList sl) {
		ResultSet rs = null;	Statement s = null; String tipoResultado;
		
		try {
			String st; int in;
			ConexionSQL con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("select * from Usuarios");
			while (rs.next()){
				st=rs.getString(1);
				in=Integer.parseInt(st);
				sl.insert(in);				
			}
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al buscar el usuario en la base de datos");
			e.printStackTrace();
		}	
			//MOVER, ORDENAR FUNCIÓN
	}
}