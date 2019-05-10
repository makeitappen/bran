//
//  Extensions.swift
//  bran
//
//  Created by Roland Michelberger on 08.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit

extension String {
    
    func instantiateInitialViewController<T: UIViewController>() -> T {
        return UIStoryboard(name: self, bundle: nil).instantiateInitialViewController() as! T
    }
}
