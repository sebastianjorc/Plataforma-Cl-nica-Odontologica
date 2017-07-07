package Controller;

import Model.User;

public class SkipList {
	/* Class SkipNode */
	class SkipNode        
	{
	    int pk;
	    User datos;
	    SkipNode right;
	    SkipNode down;
	 
	    /* Constructor */
	    public SkipNode(int x)
	    {
	        this(x, null, null, null);
	    }
	    /* Constructor */
	    public SkipNode(int x, SkipNode rt, SkipNode dt, User user)
	    {
	        pk = x;
	        right = rt;
	        down = dt;
	        datos=user;
	    }
	}
	 
	/* Class SkipList */
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
	        header = new SkipNode(infinity, tail, bottom, null);
	    }
	    /* Function to insert pk */
	    public void insert(int x, User user)
	    {
	    	SkipNode current = header;
	        bottom.pk = x;
	        while (current != bottom)
	        {
	            while (current.pk < x)
	            	current = current.right;
	            if (current.down.right.right.pk < current.pk){
	            	
	                current.right = new SkipNode(current.pk, current.right, current.down.right.right, current.datos);
	                
	                current.pk = current.down.right.pk;
	                current.datos = user;
	                
	            }
	            else	current = current.down;
	        }
	        if (header.right != tail)
	            header = new SkipNode(infinity, tail, header, user);

	        while( current.down != bottom )
	            current = current.down;
	       current.datos = user;
	    }
	    /* Function to clear list */
	    public void makeEmpty()
	    {
	        header.right = tail;
	        header.down = bottom;
	    }
	    /* Function to check if empty */
	    public boolean isEmpty()
	    {
	        return header.right == tail && header.down == bottom;
	    }
	    /* Function to get node at a position */
	    private int pkAt(SkipNode t)
	    {
	        return t == bottom ? 0 : t.pk;
	    }
	    
		public User search (int pk, String pass) {	
	    	SkipNode current = header;
	        bottom.pk = pk;
	        while (current != bottom)
	        {
	        	while (current.pk < pk)
	        		current = current.right;	        	
	        	if (current.pk==pk){
	        		if (current.datos.getPassword().equals(pass)){
		        		//System.out.println(current.datos.getPassword()+"=="+pass);
	        			//usr = new User(current.datos.getId(),current.datos.getPassword(),current.datos.getName(),current.datos.getTipoUsuario());
	        			//current.datos;
	        			return current.datos;
	        		}   	
	        	}
	        	else	current = current.down;		            
	        }	        
			return null;	
		} 
	    public void printList()
	    {
	        SkipNode current = header;
	        while( current.down != bottom )
	            current = current.down;
	        while (current.right.right != tail )
	        {
	            current = current.right;
	            System.out.print(current.pk+" - ");
	        }
	    }
	}


