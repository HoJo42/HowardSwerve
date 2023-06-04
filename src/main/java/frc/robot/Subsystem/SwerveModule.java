package frc.robot.Subsystem;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase {

    private MotorController m_speed;
    private MotorController m_rotation;

    private Encoder m_Encoder;

    /**Optimizes and sets the state
     * @param swerveModuleState field centric state
     */
    public void setState(SwerveModuleState swerveModuleState) {
    }
}
