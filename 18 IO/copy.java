0:import java.awt.BorderLayout;

1:import java.awt.EventQueue;

2:

3:import javax.swing.JFrame;

4:import javax.swing.JPanel;

5:import javax.swing.border.EmptyBorder;

6:

7:public class calculator extends JFrame {

8:

9:	private JPanel contentPane;

10:

11:	/**

12:	 * Launch the application.

13:	 */

14:	public static void main(String[] args) {

15:		EventQueue.invokeLater(new Runnable() {

16:			public void run() {

17:				try {

18:					calculator frame = new calculator();

19:					frame.setVisible(true);

20:				} catch (Exception e) {

21:					e.printStackTrace();

22:				}

23:			}

24:		});

25:	}

26:

27:	/**

28:	 * Create the frame.

29:	 */

30:	public calculator() {

31:		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

32:		setBounds(100, 100, 450, 300);

33:		contentPane = new JPanel();

34:		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

35:		setContentPane(contentPane);

36:		contentPane.setLayout(new BorderLayout(0, 0));

37:	}

38:

39:}

