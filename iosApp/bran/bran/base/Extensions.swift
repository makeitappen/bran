//
//  Extensions.swift
//  bran
//
//  Created by Roland Michelberger on 08.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit

extension UIViewController {
    
    class func instatiate(storyboard: UIStoryboard) -> UIViewController {
        return storyboard.instantiateInitialViewController()!
    }
    
}
