import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gallery extends JFrame implements ActionListener {

	JLabel img;
	int s = 1;
	int i = 0;
	JButton next, home, back, exit;
	JTextField imgpath;
	JLabel imgName, imgSize, imgLastm, sno, info, no1, no2, no3, pathlabel;

	String iconBack = "Images/back3.png";// "F:\\GalleryIcons\\back3.png";
	String iconNext = "Images/next3.png"; // "F:\\GalleryIcons\\next3.png";
	String iconexit = "Images/exit.png";// "F:\\GalleryIcons\\exit.png";
	String iconHome = "Images/home.png"; // "F:\\GalleryIcons\\home.png";
	String point = "Images/hand.png"; // "F:\\GalleryIcons\\hand.png";

	String folderPath = "ImageDatabase";
	String filepath = folderPath;
	String imagen;
	Date imagelast;
	Long imagel;

	File folder = new File(filepath);

	File[] files = folder.listFiles();
	String[] fileNames = new String[files.length];

	public Gallery() {

		/* here the array of File is created */

		for (int i = 0; i < files.length; i++) {
			fileNames[i] = files[i].getName();
		}

		String file = filepath + "/" + fileNames[i];
		File f = new File(file);
		imagen = fileNames[i];
		Date d = new Date(f.lastModified());
		imagelast = d;
		imagel = f.length();

		super.getContentPane().setBackground(Color.WHITE);
		super.setTitle("Gallery");
		super.setBounds(100, 70, 900, 650);
		super.setResizable(false);
		// --

		sno = new JLabel("Sno :" + (s));
		sno.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		sno.setBounds(70, 40, 100, 35);
		super.add(sno);

		info = new JLabel("Image Information");
		info.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		info.setBounds(540, 40, 200, 35);
		super.add(info);

		ImageIcon ic = new ImageIcon(point);
		no1 = new JLabel();
		no1.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		no1.setBounds(540, 100, 50, 35);
		super.add(no1);
		no1.setIcon(ic);

		imgName = new JLabel(imagen);
		imgName.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		imgName.setBounds(600, 100, 200, 35);
		super.add(imgName);

		no2 = new JLabel();
		no2.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		no2.setBounds(540, 200, 50, 35);
		super.add(no2);
		no2.setIcon(ic);

		imgSize = new JLabel(String.valueOf(imagel) + " Bytes");
		imgSize.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		imgSize.setBounds(600, 200, 200, 35);
		super.add(imgSize);

		no3 = new JLabel();
		no3.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		no3.setBounds(540, 300, 50, 35);
		super.add(no3);
		no3.setIcon(ic);

		imgLastm = new JLabel(String.valueOf(imagelast));
		imgLastm.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
		imgLastm.setBounds(600, 300, 350, 35);
		super.add(imgLastm);

		back = new JButton();
		back.setBounds(70, 510, 90, 90);
		super.add(back);
		ImageIcon im = new ImageIcon(iconBack);
		back.setIcon(im);
		back.addActionListener(this);

		next = new JButton();
		next.setBounds(380, 510, 90, 90);
		super.add(next);
		ImageIcon im2 = new ImageIcon(iconNext);
		next.setIcon(im2);
		next.addActionListener(this);

		exit = new JButton();
		exit.setBounds(600, 510, 220, 90);
		super.add(exit);
		ImageIcon ikon = new ImageIcon(iconexit);
		exit.setIcon(ikon);
		exit.addActionListener(this);

		home = new JButton();
		home.setBounds(230, 510, 90, 90);
		super.add(home);
		ImageIcon im3 = new ImageIcon(iconHome);
		home.setIcon(im3);
		home.addActionListener(this);

		img = new JLabel();
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK, 12, true));
		img.setBounds(70, 90, 400, 400);
		super.add(img);
		ImageIcon imgc = new ImageIcon(filepath + "/" + fileNames[i]);
		img.setIcon(imgc);

		// --
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		Gallery ref = new Gallery();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == next) {
			i++;
			if (i >= fileNames.length) {

				JOptionPane.showMessageDialog(null, "No more Photos");
				i--;

			} else {

				ImageIcon imgc = new ImageIcon(filepath + "/" + fileNames[i]);
				img.setIcon(imgc);
				s++;
				sno.setText("Sno :" + (s));

				String file = filepath + "/" + fileNames[i];
				File f = new File(file);
				imagen = fileNames[i];
				Date d = new Date(f.lastModified());
				imagelast = d;
				imagel = f.length();

				imgName.setText(imagen);
				imgSize.setText(String.valueOf(imagel));
				imgLastm.setText(imagelast.toString());

			}

		}

		if (e.getSource() == back) {

			i--;
			if (i < 0) {
				JOptionPane.showMessageDialog(null, "No more Photos");
				i = 0;
			} else {

				ImageIcon imgc = new ImageIcon(filepath + "/" + fileNames[i]);
				img.setIcon(imgc);

				s--;
				sno.setText("Sno :" + (s));

				String file = filepath + "/" + fileNames[i];
				File f = new File(file);
				imagen = fileNames[i];
				Date d = new Date(f.lastModified());
				imagelast = d;
				imagel = f.length();

				imgName.setText(imagen);
				imgSize.setText(String.valueOf(imagel));
				imgLastm.setText(imagelast.toString());

			}

		}

		if (e.getSource() == home) {
			i = 0;
			ImageIcon imgc = new ImageIcon(filepath + "/" + fileNames[i]);
			img.setIcon(imgc);

			s = 1;
			sno.setText("Sno :" + (s));

			String file = filepath + "/" + fileNames[i];
			File f = new File(file);
			imagen = fileNames[i];
			Date d = new Date(f.lastModified());
			imagelast = d;
			imagel = f.length();

			imgName.setText(imagen);
			imgSize.setText(String.valueOf(imagel));
			imgLastm.setText(imagelast.toString());

		}

		if (e.getSource() == exit) {

			super.dispose();
		}

	}

}
