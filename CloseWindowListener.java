package sims;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class CloseWindowListener implements WindowListener{
		public void windowClosing(WindowEvent e){
			int n=JOptionPane.showConfirmDialog(null, "是否确认退出并返回主界面？", "警告",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			switch(n){
			case 0:
				MainFrame m=new MainFrame();
				m.FrameMain();
				dispose();
				break;
			case -1:
			case 2:
				break;
//			default:
//				return;
			}
		}
		private void dispose() {
			// TODO 自动生成的方法存根
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO 自动生成的方法存根
			
		}
}
