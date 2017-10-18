package org.usfirst.frc.team5461.robot;

import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team5461.robot.commands.ExampleCommand1;
import org.usfirst.frc.team5461.robot.commands.ExampleCommand2;
import org.usfirst.frc.team5461.robot.triggers.ToggleJoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick stick = new Joystick(0);
	ToggleJoystickButton button = new ToggleJoystickButton(stick, 8);
	
	public OI() {
		button.whenToggled(new ExampleCommand1(), new ExampleCommand2());
	}
}
