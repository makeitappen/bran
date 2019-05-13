//
//  Extensions.swift
//  bran
//
//  Created by Roland Michelberger on 08.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit

extension UIStoryboard {
    
    convenience init(name: String) {
        self.init(name: name, bundle: nil)
    }
    
    func instantiateInitialViewController<T: UIViewController>() -> T {
        return self.instantiateInitialViewController() as! T
    }    
}
