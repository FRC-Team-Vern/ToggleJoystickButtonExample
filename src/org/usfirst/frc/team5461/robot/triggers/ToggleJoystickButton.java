package org.usfirst.frc.team5461.robot.triggers;

import java.lang.reflect.Method;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleJoystickButton extends JoystickButton {
	
	boolean m_firstCommand = true;
	
	public ToggleJoystickButton(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
	}

	public void whenToggled(Command command1, Command command2) {
		ButtonScheduler buttonScheduler = new ButtonScheduler() {
			private boolean m_pressedLast = get();

			@Override
			public void execute() {
				if (get()) {
					if (!m_pressedLast) {
						m_pressedLast = true;
						if (m_firstCommand) {
							command1.start();
						} else {
							command2.start();
						}
						m_firstCommand = !m_firstCommand;
					}
				} else {
					m_pressedLast = false;
				}
			}
		};
		
		// We can use reflection here to get at the protected method within the inner abstract class
		try {
			Method m = ButtonScheduler.class.getDeclaredMethod("start");
			m.setAccessible(true);
			m.invoke(buttonScheduler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
