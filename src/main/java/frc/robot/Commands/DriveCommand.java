package frc.robot.Commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystem.SwerveDrive;

public class DriveCommand extends CommandBase{
    private XboxController m_driveController;
    private SwerveDrive m_swerveDrive;

    public DriveCommand(XboxController controller, SwerveDrive swerveDrive) {
        m_driveController = controller;
        m_swerveDrive = swerveDrive;

        addRequirements(m_swerveDrive);
    }

    @Override
    public void execute(){
        double fwd = m_driveController.getLeftY();
        double strafe = m_driveController.getLeftX();
        double rot = m_driveController.getRightX();

        fwd = Math.signum(fwd) * fwd * fwd * Constants.maxWheelSpeed;
        strafe = Math.signum(strafe) * strafe * strafe * Constants.maxWheelSpeed;
        rot = Math.signum(rot) * rot * rot * Constants.maxAngleSpeed;

        m_swerveDrive.drive(new ChassisSpeeds(fwd, strafe, rot));
    }

}
