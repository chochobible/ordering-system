package sec01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Scanner;


class GUI extends JFrame 
{	
	private JRadioButton res, to;	
	private ButtonGroup group;
	private JLabel logo_name, delivery_type, date_time, table_no, name, address, contact, toppings_label, quantity_label;
	private JTextField table_no_tf, name_tf, address_tf, contact_tf;
	private JPanel input_panel, delivery_panel, toppings_panel, toppings2_panel, quantity_panel, initial_panel, buttons_panel;
	private JPanel top1_panel, top2_panel;
	private JCheckBox onion, pepper, olive, pickle, lettuce, tomato;

	String date;
	public float rate = 80;

	private JLabel quantity_op_label, quantity_op, rate_label, rate_op_label;
	private JButton print, clear, calculate;
	private JLabel table_no_op, name_op, address_op, contact_op;
	String table_no_str, name_str, address_str, contact_str;
	private JLabel table_no2, name2, address2, contact2;
	private JLabel date_time2;
	private JLabel logo_name2;
	
	//�ֹ� �� Message Dialog â ����
	public GUI() 
	{
		super("Subway");
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));			
		logo_name = new JLabel("Subway", 0);
		initial_panel = new JPanel();
		initial_panel.setLayout(new GridLayout(2, 1));		
		
		JOptionPane.showMessageDialog(new JFrame(), "�ֹ��Ͻ� ������� �������� �Է��ϼ���", "Subway", JOptionPane.PLAIN_MESSAGE);
		
		//Logo Icon and Name
		logo_name = new JLabel("Subway", 0);		
		initial_panel.add(logo_name);
		
		//Date and Time
		date = new SimpleDateFormat("yyyy-MM-dd  a hh:mm:ss").format(new Date());
		date_time = new JLabel(date);
		initial_panel.add(date_time);					
			
		add(initial_panel);	
	}
	
	//�ֹ����� �ʿ��� ���� �Է��ϴ� �޼ҵ�
	public void Input()
	{		
		input_panel = new JPanel();
		input_panel.setLayout(new GridLayout(5, 2, 4, 5));	
					
		delivery_panel = new JPanel();
		delivery_panel.setLayout(new GridLayout(1, 3));			
		
		//1. �Ļ� ��� ����
		delivery_type = new JLabel("1. �Ļ��Ͻ� ��Ҹ� �������ּ���: ");
		res = new JRadioButton("���忡�� �Ļ�");
		res.setActionCommand("res"); //res = restaurant
		to = new JRadioButton("����ũ �ƿ�");
		to.setActionCommand("to"); //to = take-out
		
		group = new ButtonGroup();
		group.add(res);
		group.add(to);
		delivery_panel.add(res);
		delivery_panel.add(to);
		
		input_panel.add(delivery_type);					
		input_panel.add(delivery_panel);		
		
		//2. ���̺� ��ȣ �Է�
		table_no = new JLabel("2. ���̺� ��ȣ:");		
		table_no_tf = new JTextField("", 5);
		input_panel.add(table_no);
		input_panel.add(table_no_tf);						
		
		//3. �̸�, 4. �ּ�, 5. ����ó �Է�
		name = new JLabel("3. �̸�:");
		address = new JLabel("4. �ּ�:");
		contact = new JLabel("5. ����ó:");
		name_tf = new JTextField("", 10);
		address_tf = new JTextField("", 20);
		contact_tf = new JTextField("", 10);
		input_panel.add(name);
		input_panel.add(name_tf);					
		input_panel.add(address);
		input_panel.add(address_tf);
		input_panel.add(contact);
		input_panel.add(contact_tf);
				
		add(input_panel);
		
	
		//1. �Ļ� ��� (RadioButton)�� ���� �ؽ�Ʈ�ʵ� Ȱ��ȭ
		res.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(res.isSelected())
				{
					name.setEnabled(false);
					address.setEnabled(false);
					contact.setEnabled(false); 
					name_tf.setEditable(false);
					address_tf.setEditable(false);
					contact_tf.setEditable(false);	
					name_tf.setEnabled(false);
					address_tf.setEnabled(false);
					contact_tf.setEnabled(false);
					table_no.setEnabled(true);
					table_no_tf.setEnabled(true);					
					table_no_tf.setEditable(true);		
				}
			}
		});
		
		to.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(to.isSelected())
				{
					table_no.setEnabled(false);
					table_no_tf.setEnabled(false);					
					table_no_tf.setEditable(false);
					name.setEnabled(true);
					address.setEnabled(true);
					contact.setEnabled(true); 
					name_tf.setEditable(true);
					address_tf.setEditable(true);
					contact_tf.setEditable(true);	
					name_tf.setEnabled(true);
					address_tf.setEnabled(true);
					contact_tf.setEnabled(true);				
				}
			}
		});								
	}
	
	//��ἱ���ϴ� �޼ҵ�
	public void Toppings()
	{
		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		
		toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(2, 1));
		
		toppings2_panel = new JPanel();
		toppings2_panel.setLayout(new GridLayout(2, 1));
		
		toppings_label = new JLabel("Toppings:");	
		
		onion = new JCheckBox("����(onion)", false);
		pepper = new JCheckBox("�Ǹ�(pepper) ", false);
		olive = new JCheckBox("�ø���(olive) ", false);
		pickle = new JCheckBox("��Ŭ(pickle) ", false);
		lettuce = new JCheckBox("�����(lettuce) ", false);
		tomato = new JCheckBox("�丶��(tomato) ", false);
				
		ItemListener itemListener = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					rate = rate + 15;
				}
			}
		};
			
		onion.addItemListener(itemListener);
		pepper.addItemListener(itemListener);
		olive.addItemListener(itemListener);
		pickle.addItemListener(itemListener);
		lettuce.addItemListener(itemListener);
		tomato.addItemListener(itemListener);	
		
		top1_panel.add(onion);
		top1_panel.add(pepper);
		top1_panel.add(olive);	
		top2_panel.add(pickle);
		top2_panel.add(lettuce);	
		top2_panel.add(tomato);						
	
		toppings_panel.add(top1_panel);
		toppings_panel.add(top2_panel);
					
		toppings2_panel.add(toppings_label);
		toppings2_panel.add(toppings_panel);
		add(toppings2_panel);
	}
	
	//���� �����ϴ� �޼ҵ�
	public void Quantity() 
	{
		quantity_label = new JLabel("����: ");
		quantity_op_label = new JLabel("����: ");
		quantity_op = new JLabel();
		quantity_panel = new JPanel();
		quantity_panel.setLayout(new GridLayout(2, 2));
		String[] quantity = {"1", "2", "3", "4", "5"};
		
		JComboBox<String>quantity_box = new JComboBox<String>();
		for(int i = 0; i < quantity.length; i++)		
			quantity_box.addItem(quantity[i]);
		
		quantity_box.setSelectedIndex(0);
						
		quantity_panel.add(quantity_label);
		quantity_panel.add(quantity_box);
		
		
		quantity_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				quantity_op.setText((String)((JComboBox)e.getSource()).getSelectedItem());
			}	
		});

		add(quantity_panel);
	} 
	
	//���ȭ�� ���� �޼ҵ�
	public void Result()
	{	
		
		buttons_panel = new JPanel();
		buttons_panel.setLayout(new GridLayout(1, 2, 50, 10));
					
		table_no2 = new JLabel("���̺��ȣ: ");
		name2 = new JLabel("�̸�: ");
		address2 = new JLabel("�ּ�: ");
		contact2= new JLabel("����ó: ");
		
		print = new JButton("Print");
		clear = new JButton("Clear");
	
		buttons_panel.add(print);
		buttons_panel.add(clear);		
			
		add(buttons_panel);
						
				
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				table_no_tf.setText("");
				name_tf.setText("");
				address_tf.setText("");
				contact_tf.setText("");
				group.clearSelection();
				name.setEnabled(true);
				address.setEnabled(true);
				contact.setEnabled(true); 
					
				name_tf.setEditable(true);
				address_tf.setEditable(true);
				contact_tf.setEditable(true);	
				name_tf.setEnabled(true);
				address_tf.setEnabled(true);
				contact_tf.setEnabled(true);
				table_no.setEnabled(true);
				table_no_tf.setEnabled(true);					
				table_no_tf.setEditable(true);
				
				onion.setSelected(false);
				pepper.setSelected(false);
				olive.setSelected(false);
				pickle.setSelected(false);
				lettuce.setSelected(false);
				tomato.setSelected(false);		
			}
		});
		
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String rate_str;
				rate_str = Float.toString(rate);
				rate_label = new JLabel("Rate: ");
				rate_op_label = new JLabel(rate_str);
							
				JFrame output = new JFrame();
				output.setLayout(new GridLayout(8, 2));
				
				logo_name2 = new JLabel("Subway", 0);		
				output.add(logo_name2);				
				date = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss").format(new Date());							
				date_time2 = new JLabel(date);
				output.add(date_time2);										
				
				table_no_str = table_no_tf.getText();
				name_str = name_tf.getText();
				address_str = address_tf.getText();
				contact_str = contact_tf.getText();
				
				table_no_op = new JLabel(table_no_str);
				name_op = new JLabel(name_str);
				address_op = new JLabel(address_str);
				contact_op = new JLabel(contact_str);
				
				output.add(table_no2);
				output.add(table_no_op);
				output.add(name2);
				output.add(name_op);
				output.add(address2);
				output.add(address_op);
				output.add(contact2);
				output.add(contact_op);	
				
				output.add(quantity_op_label);				
				output.add(quantity_op);
				output.pack();
				output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				output.setLocationRelativeTo(null);
				output.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "�ֹ��� �Ϸ�Ǿ����ϴ�!");
			}
		});
	}		
}

//���θ޼ҵ�
class Order
{
	public static void main(String[] args) 
	{
	
		GUI g = new GUI();
		String msg;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ ����: �̴���/������/ȫ����"); //�̴����� ����
		msg = scanner.nextLine();
			
		g.Input();		
		g.Toppings();
		g.Quantity();			
		g.Result();	
					
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setLocationByPlatform(true);
			
			
		g.setSize(575,600);
		g.setVisible(true);
	}			
}