package associations;

public class Partner {
    private String name;
    private Partner partner;

    private void setOtherPartner(Partner partner) {
        this.partner = partner;
    }

    public Partner(String name, Partner partner) {
        this.name = name;
        this.setPartner(partner);
    }

    public Partner(String name) {
        this.name = name;
    }

    public void setPartner(Partner partner) {
        if (partner != null) {
            if (this.partner != null) {
                Partner p = this.getPartner();
                p.setOtherPartner(null);
                Partner q = partner.getPartner();
                q.setOtherPartner(null);
            }
            this.partner = partner;
            partner.setOtherPartner(this);
            } else {
                    if (this.partner != null ) {
                        Partner p = this.getPartner();
                        p.setOtherPartner(null);
                        this.partner = null;
                    }
            }
    }
    
    public String getName() {
        if (name == null) {
            return "null";
        }
        return name;
    }
    public Partner getPartner() {
        return partner;
    }

    @Override
    public String toString() {
        try {
            return "Partner [name=" + this.getName() + ", partner=" + partner.getName() + "]";
        } catch (Exception e) {
            return "Partner [name=" + this.getName() + ", partner=" + null + "]";
        }
    }

    public static void main(String[] args) {
        Partner p1 = new Partner("p1", null);
        Partner p2 = new Partner("p2", null);
/*
        p1.setPartner(p2);
        
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        
        System.out.println(p1.getPartner());
        System.out.println(p2.getPartner());
        
        p1.setPartner(null);

        System.out.println(p1.getPartner());
        System.out.println(p2.getPartner());
        
        System.out.println(p1);
        System.out.println(p2);
*/ 
        Partner p3 = new Partner("p3");
//      System.out.println(p3);

        Partner p4 = new Partner("p4");
 
        p1.setPartner(p2);
		p3.setPartner(p4);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        p1.setPartner(p4);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
